package ua.springboot.web.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.Ticket;
import ua.springboot.web.entity.enumeration.Gender;
import ua.springboot.web.entity.enumeration.Role;
import ua.springboot.web.validator.CheckEmailExists;


@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {

	private int id;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z0-9_]{2,10}$", message="Login not match")
    private String login;
	@NotBlank(message = "Cant be empty") @Pattern(regexp="^{4,10}$", message="Password too small")
    private String password;
    @NotBlank(message = "Cant be empty") @CheckEmailExists
	private String email;
	
    @NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="First Name not match") 
	private String firstName;
    @NotBlank(message = "Cant be empty") @Pattern(regexp="^[a-zA-Z]{2,10}$", message="Last Name not match")
	private String lastName;
	private Gender gender;
	
	@NotNull(message = "Cant be empty") @Pattern(regexp="^[0-9]{10}$", message="Mobile not match")
	private String mobile;
	@NotNull(message = "Cant be empty") @Pattern(regexp="^[0-9]{1,3}$", message="Age not match")
	private String age;
	@NotNull(message = "Cant be empty") @Min(100) @Max(1000)
	private BigDecimal balance;
	private List<Ticket> tickets;
	
	private Role role;
	private boolean isActivated;
	private MultipartFile file;
//	private Country country;
	
	
}
