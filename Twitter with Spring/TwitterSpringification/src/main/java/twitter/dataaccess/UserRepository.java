package twitter.dataaccess;

import java.util.List;

import twitter.domain.MyUser;

public interface UserRepository {
	public void save(MyUser user);
	public void delete(Long id);
	public void update(MyUser user);
	public List<MyUser> list();
	public MyUser find(Long id);
	public MyUser findByNick(String nick);
}
