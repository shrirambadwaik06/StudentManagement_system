package student_management_system.entity;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = " student")
@NoArgsConstructor
@AllArgsConstructor
public class student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
    private String lastName;
	
	@Column(nullable = false , name = "Email")
	@Email
	private String email;
	
	@Column(nullable = false , name = "Phone")
	private String phone;
	
	@Column(nullable = false , name = "Branch")
	private String branch;
	
    
}
