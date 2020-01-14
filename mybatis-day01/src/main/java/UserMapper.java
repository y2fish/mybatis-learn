import java.util.List;

public interface UserMapper {
  List<User> getAll();
  void insertUser(User user);
}
