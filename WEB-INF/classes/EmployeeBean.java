package bean;
public class EmployeeBean{
  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private String mobile;
  private String address;
  private String department;
  private String post;
  private String qualification;
  private String experience;
  private String dob;
  private String salary;
  private String activity;

  private String marital;
  private String language;
  private String username;
  private String password;
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

  public void setDepartment(String department)
  {
    this.department=department;
  }
  public String getDepartment()
  {
    return department;
  }

  public void setPost(String post)
  {
    this.post=post;
  }
  public String getPost()
  {
    return post;
  }

  public void setQualification(String qualification)
  {
    this.qualification=qualification;
  }
  public String getQualification()
  {
    return qualification;
  }

  public void setExperience(String experience)
  {
    this.experience=experience;
  }
  public String getExperience()
  {
    return experience;
  }

  public void setDob(String dob)
  {
    this.dob=dob;
  }
  public String getDob()
  {
    return dob;
  }
  public void setSalary(String salary)
  {
    this.salary=salary;
  }
  public String getSalary()
  {
    return salary;
  }
  public void setActivity(String activity)
  {
    this.activity=activity;
  }
  public String getActivity()
  {
    return activity;
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
