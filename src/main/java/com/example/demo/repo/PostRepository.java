// файл для управления табличкой из базы данных
package com.example.demo.repo;

import com.example.demo.models.Post;
import org.springframework.data.repository.CrudRepository; // CrudRepository встроенный интерфейс, в котором есть все необходимые функции
// для того, чтобы мы могли добавить запись в табличку, удалить запись из таблички, обновить и вытянуть запись из таблички

public interface PostRepository extends CrudRepository <Post, Long> {

}
