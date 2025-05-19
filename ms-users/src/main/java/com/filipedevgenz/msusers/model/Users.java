package com.filipedevgenz.msusers.model;
import com.filipedevgenz.msusers.infra.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("tb_users")
@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID userId;
    @ElementCollection
    @CollectionTable(name = "user_deposit_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "deposit_id")
    private List<String> depositId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
    int numOfDeposits = 0;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == UserRole.VIP){
            return List.of(
                new SimpleGrantedAuthority("ROLE_VIP"),
                new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
