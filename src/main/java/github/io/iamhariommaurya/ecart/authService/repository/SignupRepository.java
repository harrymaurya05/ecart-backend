package github.io.iamhariommaurya.ecart.authService.repository;


import github.io.iamhariommaurya.ecart.authService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<User,Long> {
}
