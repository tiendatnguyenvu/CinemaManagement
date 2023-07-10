/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidMoneyException extends Exception {
    private String invalidMoney;

    public InvalidMoneyException(String message, String invalidMoney) {
        super(message);
        this.invalidMoney = invalidMoney;
    }

    public String getInvalidMoney() {
        return invalidMoney;
    }

    public void setInvalidMoney(String invalidMoney) {
        this.invalidMoney = invalidMoney;
    }
}
