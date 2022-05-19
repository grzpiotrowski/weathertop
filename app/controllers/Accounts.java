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

  /**
   * Creates a new member in the database
   * @param firstName First Name
   * @param lastName Last Name
   * @param email Email
   * @param password Password
   */
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
    if (password.equals("")) {
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
      render("signup.html", firstName, lastName, email, errormessages);
    }
  }

  /**
   * Authenticates member login
   * @param email Email
   * @param password Password
   */
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with: " + email + ":" + password);
    HashSet<String> errormessages = new HashSet<>();
    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password))) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      errormessages.add("Incorrect login or password!");
      render("login.html", errormessages);
    }
  }

  public static void logout()
  {
    session.clear();
    redirect("/");
  }

  /**
   * Returns currently logged in Member
   * @return Member logged in current session
   */
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

  /**
   * Changes Member's details in the database
   * @param firstname First Name
   * @param lastname Last Name
   */
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
