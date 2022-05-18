package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.HashMap;
import java.util.HashSet;

public class Accounts extends Controller
{
  public static void signup() { render("signup.html"); }

  public static void login()
  {
    render("login.html");
  }

  public static void settings()
  {
    String firstname = getLoggedInMember().firstName;
    String lastname = getLoggedInMember().lastName;
    render("accountsettings.html", firstname, lastname);
  }


  public static void register(String firstName, String lastName, String email, String password)
  {
    HashSet<String> errormessages = new HashSet<>();
    if (Member.isEmailExisting(email)) {
      Logger.info("Email already taken: " + email);
      errormessages.add("Email already taken.");
    }
    if (email.equals("")) {
      errormessages.add("Email is required.");
    }
    if (lastName.equals("")) {
      errormessages.add("Password is required.");
    }
    if (firstName.equals("")) {
      errormessages.add("First Name is required.");
    }
    if (lastName.equals("")) {
      errormessages.add("Last Name is required.");
    }

    if (errormessages.isEmpty()) {
      Logger.info("Registering new user: " + email);
      Member member = new Member(firstName, lastName, email, password);
      member.save();
      redirect("/");
    } else {
      render("signup.html", errormessages);
    }
  }

  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with: " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password))) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      redirect("/login");
    }
  }

  public static void logout()
  {
    session.clear();
    redirect("/");
  }

  public static Member getLoggedInMember()
  {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }

  public static void changeMemberDetails(String firstname, String lastname) {
    Member member = getLoggedInMember();
    if (member != null) {
      member.firstName = firstname;
      member.lastName = lastname;
      member.save();
      redirect("/accountsettings");
    }
  }

}
