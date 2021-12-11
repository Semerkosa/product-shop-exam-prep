package demo.shoppinglist.models.binding;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {

    @NotBlank(message = "Username must not be empty!")
    @Size(min = 3, max = 20, message = "Username must be 3-20 chars long!")
    private String username;

    @Email(message = "Enter a valid email!")
    @NotNull(message = "Enter a valid email!")
    private String email;

    @NotNull(message = "Password must not be empty!")
    @Size(min = 3, max = 20, message = "Password must be 3-20 chars long!")
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
