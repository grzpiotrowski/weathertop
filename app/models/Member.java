package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Member extends Model {
  public String firstName;
  public String lastName;
  public String email;
  public String password;

  @OneToMany(cascade = CascadeType.ALL)
  @OrderBy("name ASC")
  public List<Station> stations = new ArrayList<Station>();

  public Member(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public static Member findByEmail(String email) {
    return find("email", email).first();
  }

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }

  /**
   * Checks if Member with specified email address exists
   *
   * @param email Email address
   * @return true: Member exists, false: Member does not exist
   */
  public static boolean isEmailExisting(String email) {
    if (find("email", email).first() != null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if Station's name has already been used
   *
   * @param name Station's name
   * @return true: station exists, false: station does not exist
   */
  public boolean hasStation(String name) {
    for (Station station : stations) {
      if (station.name.equals(name)) {
        return true;
      }
    }
    return false;
  }

}
