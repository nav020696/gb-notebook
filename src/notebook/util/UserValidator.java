package notebook.util;

import notebook.model.User;

public class UserValidator {
    public String isValid(String data){
        if (data.isEmpty()){
            throw new IllegalArgumentException("Некорректное значение");
        } else{
            return data.replaceAll(" ", "").trim();
        }
    }
}
