package bean;
public class UserBean{
  private int id;
  private String firstname,lastname,email,mobile,address,place,username,password;
  boolean status;
  public void setStatus(boolean status)
  {
    this.status=status;
  }

  public boolean getStatus()
  {
    return status;
  }


  public void setID(int id)
  {
    this.id=id;
  }
  public int getID()
  {
    return id;
  }
  public void setFirstName(String firstname)
  {
    this.firstname=firstname;
  }
  public String getFirstName()
  {
    return firstname;
  }

  public void setLastName(String lastname)
  {
    this.lastname=lastname;
  }
  public String getLastName()
  {
    return lastname;
  }
  public void setEmail(String email)
  {
    this.email=email;
  }
  public String getEmail()
  {
    return email;
  }

  public void setMobile(String mobile)
  {
    this.mobile=mobile;
  }
  public String getMobile()
  {
    return mobile;
  }

  public void setAddress(String address)
  {
    this.address=address;
  }
  public String getAddress()
  {
    return address;
  }

  public void setPlace(String place)
    {
      this.place=place;
    }
    public String getPlace()
    {
      return place;
    }

  public void setUsername(String username)
  {
    this.username=username;
  }
public String getUsername()
{
  return username;
}

  public void setPassword(String password)
  {
    this.password=password;
  }
  public String getPassword()
  {
    return password;
  }
}
