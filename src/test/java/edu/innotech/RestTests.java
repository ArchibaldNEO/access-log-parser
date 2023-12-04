package edu.innotech;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;

import io.restassured.*;

import java.util.ArrayList;
import java.util.List;

public class RestTests {
  Pupil pupil = new Pupil();
  ObjectMapper objectMapper = new ObjectMapper();

  int id = 99;
  String name = "Artem";
  List<Integer> marks = new ArrayList<>();


  @BeforeEach
  @SneakyThrows
  @DisplayName("Создаем студента")
  public void createStudent() {
    marks.add(2);
    marks.add(5);
    marks.add(3);
    marks.add(2);
    marks.add(4);


    pupil.setId(id);
    pupil.setName(name);
    pupil.setMarks(marks);

    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201);

  }

  @Test
  @SneakyThrows
  @DisplayName("1) get /student/{id} возвращает JSON студента с указанным ID и заполненным именем, если такой есть в базе, код 200")
  public void test1() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id)
            .contentType(ContentType.JSON)
            .when().get().then()
            .contentType(ContentType.JSON)
            .statusCode(200);

    String json = objectMapper.writeValueAsString(pupil);
    JsonPath jsonPath = new JsonPath(json);

    Assertions.assertEquals(id, jsonPath.getInt("id"));
    Assertions.assertEquals(name, jsonPath.getString("name"));
    Assertions.assertEquals(marks, jsonPath.getList("marks"));

  }

  @Test
  @DisplayName("2) get /student/{id} возвращает код 404, если студента с данным ID в базе нет")
  public void test2() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id + 1)
            .contentType(ContentType.JSON)
            .when().get().then()
            .contentType("")
            .statusCode(404);
  }


  @Test
  @SneakyThrows
  @DisplayName("3) post /student добавляет студента в базу, если студента с таким ID ранее не было, при этом имя заполнено, код 201.")
  public void test3() {
    int ids = 999;
    pupil.setId(ids);
    pupil.setName("Mark");
    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201);

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + ids)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);
  }

  @Test
  @SneakyThrows
  @DisplayName("4) post /student обновляет студента в базе, если студент с таким ID ранее был, при этом имя заполнено, код 201")
  public void test4() {
    pupil.setName("Andre");
    marks.add(5);
    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201)
            .extract().response();

    Assertions.assertEquals("", response.asString());

  }

  @Test
  @SneakyThrows
  @DisplayName("5) post /student добавляет студента в базу, если ID null, то возвращается назначенный ID, код 201.")
  public void test5() {
    pupil.setId(null);
    pupil.setName("Mark");
    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201)
            .extract().response();

    Assertions.assertNotNull(response.asString());

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + response.asString())
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);
  }

  @Test
  @SneakyThrows
  @DisplayName("6.1) post /student возвращает код 400, если имя - null.")
  public void test6_1() {
    pupil.setId(241);
    pupil.setName(null);
    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(400)
            .extract().response();

    Assertions.assertEquals("", response.asString());


  }

  @Test
  @SneakyThrows
  @DisplayName("6.2) post /student возвращает код 201, если имя - пустая строка.")
  public void test6_2() {
    int ids = 241;
    pupil.setId(ids);
    pupil.setName("");
    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201)
            .extract().response();

    Assertions.assertEquals("", response.asString());

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + ids)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);
  }

  @Test
  @DisplayName("7) delete /student/{id} удаляет студента с указанным ID из базы, код 200")
  public void test7() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);
  }

  @Test
  @DisplayName("8) delete /student/{id} возвращает код 404, если студента с таким ID в базе нет")
  public void test8() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id + 9999)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(404);
  }

  @Test
  @DisplayName("9) get /topStudent код 200 и пустое тело, если студентов в базе нет.")
  public void test9() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);

    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/topStudent")
            .when().get().then()
            .statusCode(200)
            .extract().response();

    Assertions.assertEquals("", response.asString());
  }

  @Test
  @SneakyThrows
  @DisplayName("10) get /topStudent код 200 и пустое тело, если ни у кого из студентов в базе нет оценок.")
  public void test10() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);


    pupil.setMarks(null);

    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil))
            .when().post().then()
            .statusCode(201);

    Response response = RestAssured.given()
            .baseUri("http://localhost:8080/topStudent")
            .when().get().then()
            .statusCode(200)
            .extract().response();

    Assertions.assertEquals("", response.asString());

  }

  @Test
  @SneakyThrows
  @DisplayName("11) get /topStudent код 200 и один студент, если у него максимальная средняя оценка, " +
          "либо же среди всех студентов с максимальной средней у него их больше всего.")
  public void test11() {
    RestAssured.given()
            .baseUri("http://localhost:8080/topStudent")
            .when().get().then()
            .statusCode(200)
            .extract().response();

    String json = objectMapper.writeValueAsString(pupil);
    JsonPath jsonPath = new JsonPath(json);

    Assertions.assertEquals(id, jsonPath.getInt("id"));
    Assertions.assertEquals(name, jsonPath.getString("name"));
    Assertions.assertEquals(marks, jsonPath.getList("marks"));

  }

  @Test
  @SneakyThrows
  @DisplayName("12) get /topStudent код 200 и несколько студентов, " +
          "если у них всех эта оценка максимальная и при этом они равны по количеству оценок")
  public void test12() {
    Pupil pupil1 = new Pupil();
    Pupil pupil2 = new Pupil();
    Pupil pupil3 = new Pupil();

    int id1 = 1;
    String name1 = "Artem1";

    int id2 = 2;
    String name2 = "Artem2";

    int id3 = 3;
    String name3 = "Artem3";


    pupil1.setId(id1);
    pupil1.setName(name1);
    pupil1.setMarks(marks);

    pupil2.setId(id2);
    pupil2.setName(name2);
    pupil2.setMarks(marks);

    pupil3.setId(id3);
    pupil3.setName(name3);
    pupil3.setMarks(marks);

    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil1))
            .when().post().then()
            .statusCode(201);

    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil2))
            .when().post().then()
            .statusCode(201);

    RestAssured.given()
            .baseUri("http://localhost:8080/student")
            .contentType(ContentType.JSON)
            .body(objectMapper.writeValueAsString(pupil3))
            .when().post().then()
            .statusCode(201);




    RestAssured.given()
            .baseUri("http://localhost:8080/topStudent")
            .when().get().then()
            .statusCode(200)
            .extract().response();


    JsonPath jsonPath = new JsonPath(objectMapper.writeValueAsString(pupil));
    JsonPath jsonPath1 = new JsonPath(objectMapper.writeValueAsString(pupil1));
    JsonPath jsonPath2 = new JsonPath(objectMapper.writeValueAsString(pupil2));
    JsonPath jsonPath3 = new JsonPath(objectMapper.writeValueAsString(pupil3));

    Assertions.assertEquals(id, jsonPath.getInt("id"));
    Assertions.assertEquals(name, jsonPath.getString("name"));
    Assertions.assertEquals(marks, jsonPath.getList("marks"));

    Assertions.assertEquals(id1, jsonPath1.getInt("id"));
    Assertions.assertEquals(name1, jsonPath1.getString("name"));
    Assertions.assertEquals(marks, jsonPath1.getList("marks"));

    Assertions.assertEquals(id2, jsonPath2.getInt("id"));
    Assertions.assertEquals(name2, jsonPath2.getString("name"));
    Assertions.assertEquals(marks, jsonPath2.getList("marks"));

    Assertions.assertEquals(id3, jsonPath3.getInt("id"));
    Assertions.assertEquals(name3, jsonPath3.getString("name"));
    Assertions.assertEquals(marks, jsonPath3.getList("marks"));

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id1)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id2)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);

    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id3)
            .contentType(ContentType.JSON)
            .when().delete().then()
            .statusCode(200);

  }

  @AfterEach
  @DisplayName("Удаляем студента")
  public void deleteStudent() {
    RestAssured.given()
            .baseUri("http://localhost:8080/student/" + id)
            .contentType(ContentType.JSON)
            .when().delete().then();
  }

}
