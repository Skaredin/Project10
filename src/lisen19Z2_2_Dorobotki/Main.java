package lisen19Z2_2_Dorobotki;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
    JSONObject library = new JSONObject();
    JSONArray books = new JSONArray();

    JSONObject book1 = new JSONObject();

    book1.put("Book"," Книги ");
    book1.put("Product"," Покупки/продукты ");
    book1.put("Task", "Задачи");
    book1.put("Birthday"," Дни рождений людей");
    book1.put("Animals"," Домашние животные ");
    book1.put("Lesson", "Предметы в университете ");
    book1.put("Automobile"," Автомобили ");
    book1.put("Employee"," Сотрудники ");
    book1.put("Movies"," Фильмы  ");
    book1.put("Songs"," Музыкальные произведений  ");

    books.add(book1);

    library.put("books", books);

    try(FileWriter file = new FileWriter("src/lisen19Z2_2_Dorobotki/example.json")) {

        file.write(library.toJSONString());
        System.out.println("json file trye");
    }  catch (Exception e) {
        e.printStackTrace();

    }
}
}
