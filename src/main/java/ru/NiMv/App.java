package ru.NiMv;

import ru.NiMv.Service.ApiService;
import ru.NiMv.model.User;

public class App {
    public static void main(String[] args) {

        // Создание экземпляра сервиса API
        ApiService apiService = new ApiService();

        // Получение sessionId
        apiService.getSessionId();

        // Подготовка данных для сохранения нового пользователя
        User userToSave = new User(3L, "James", "Brown", (byte) 30);
        // Сохранение пользователя
        String saveResult = apiService.saveUser(userToSave);
        System.out.println("Результат сохранения пользователя: " + saveResult);

        // Подготовка данных для обновления пользователя
        User userToUpdate = new User(3L, "Thomas", "Shelby", (byte) 30);
        // Обновление пользователя
        String updateResult = apiService.updateUser(userToUpdate);
        System.out.println("Результат обновления пользователя: " + updateResult);

        // Удаление пользователя
        Long userIdToDelete = 3L;
        String deleteResult = apiService.deleteUser(userIdToDelete);
        System.out.println("Результат удаления пользователя: " + deleteResult);

        // Вывод итогового результата
        System.out.println("Итоговый код: " + saveResult + updateResult + deleteResult);
    }
}
