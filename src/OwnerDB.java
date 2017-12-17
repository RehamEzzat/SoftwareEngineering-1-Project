import java.util.ArrayList;
import java.util.List;

public class OwnerDB {

	private static ArrayList<StoreOwner> owners = new ArrayList<StoreOwner>();

	public OwnerDB() {
	}

	public static void addOwner(StoreOwner owner) {
		owners.add(owner);
	}

	public static void removeOwner(String userName) {
	}

	public static void updateOwner(String userName) {
	}

	public static StoreOwner getOwner(String userName) {
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getUserName().equals(userName)) {
				return owners.get(i);
			}
		}
		return null;
	}

	public static ArrayList<StoreOwner> getAllOwners() {
		return owners;
	}

	public static ArrayList<User> convertOwnersToUsers() {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < owners.size(); i++) {
			User user = owners.get(i);
			users.add(user);
		}
		return users;
	}

}