package com.teste.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroGmailPojo {
    
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(name = "Passwd")
    private WebElement password;
    @FindBy(name= "ConfirmPasswd")
    private WebElement confirmPassword;
    @FindBy(id = "accountDetailsNext")
    private WebElement botao;
    @FindBy(id = "phoneNumberId")
    private WebElement telefone;
    @FindBy(id = "gradsIdvPhoneNext")
    private WebElement botaoTelefone;
    private final WebDriver driver;
    private String url;

    public CadastroGmailPojo(WebDriver driver) {
        this.driver = driver;
    }
    
    public void logar(String nome, String sobreNome, String nomeUsuario, String senha){
        this.firstName.sendKeys(nome);
        this.lastName.sendKeys(sobreNome);
        this.username.sendKeys(nomeUsuario);
        this.password.sendKeys(senha);
        this.confirmPassword.sendKeys(senha);
        this.botao.click();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public boolean checkUrl(String url){
        if(driver.getCurrentUrl().contentEquals(url)){
            return true;
        }
        return false;
    }
    
    private void waitTime(int seconds){
        (new WebDriverWait(driver, seconds)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("NetBeans");
            }
        });
    }
}
