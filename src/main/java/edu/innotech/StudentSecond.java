package edu.innotech;

import edu.innotech.mocks.StudentRepository;
import lombok.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class StudentSecond {


  @Setter
  private StudentRepository repo;

  @Getter
  @Setter
  private String name;
  private List grades = new ArrayList<>();

  public StudentSecond(String name) {
    this.name = name;
  }

  public List getGrades() {
    return new ArrayList<>(grades);
  }

  @SneakyThrows
  public void addGrade(int grade) {

    if (!repo.checkGrade(grade)) {
      throw new IllegalArgumentException(grade + " is wrong grade");
    }
    grades.add(grade);

   /* CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet request = new HttpGet("http://localhost:5352/checkGrade?grade=" + grade);
    System.out.println(request);
    CloseableHttpResponse httpResponse = httpClient.execute(request);
    HttpEntity entity = httpResponse.getEntity();
    if (!Boolean.parseBoolean(EntityUtils.toString(entity))) {
      throw new IllegalArgumentException(grade + " is wrong grade");
    }
    grades.add(grade);*/
  }

  @SneakyThrows
  public int raiting() {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet request = new HttpGet("http://localhost:5352/educ?sum=" + grades.stream().mapToInt(x -> (int) x).sum());
    CloseableHttpResponse httpResponse = httpClient.execute(request);
    HttpEntity entity = httpResponse.getEntity();
    return Integer.parseInt(EntityUtils.toString(entity));
  }


}