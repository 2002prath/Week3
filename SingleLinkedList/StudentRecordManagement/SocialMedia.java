package SingleLinkedList.StudentRecordManagement;

import java.util.*;

class SocialMedia {

    // Friend List Node (for storing friend IDs)
    static class FriendNode {
        int friendID;
        FriendNode next;

        FriendNode(int id) {
            this.friendID = id;
            this.next = null;
        }
    }

    // User Node (Main Linked List)
    static class UserNode {
        int userID;
        String name;
        int age;
        FriendNode friends; // Linked List of Friends
        UserNode next;

        UserNode(int id, String name, int age) {
            this.userID = id;
            this.name = name;
            this.age = age;
            this.friends = null;
            this.next = null;
        }
    }

    // Head of the User Linked List
    private UserNode head;

    // Add a new user to the system
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("✅ User " + name + " added successfully!");
    }

    // Find a user by ID
    private UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("❌ One or both users not found!");
            return;
        }

        // Add user2 to user1's friend list
        FriendNode newFriend1 = new FriendNode(userID2);
        newFriend1.next = user1.friends;
        user1.friends = newFriend1;

        // Add user1 to user2's friend list
        FriendNode newFriend2 = new FriendNode(userID1);
        newFriend2.next = user2.friends;
        user2.friends = newFriend2;

        System.out.println("✅ Friendship added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("❌ One or both users not found!");
            return;
        }

        user1.friends = removeFriendFromList(user1.friends, userID2);
        user2.friends = removeFriendFromList(user2.friends, userID1);

        System.out.println("✅ Friendship removed between " + user1.name + " and " + user2.name);
    }

    // Helper method to remove a friend from a user's friend list
    private FriendNode removeFriendFromList(FriendNode head, int friendID) {
        if (head == null) return null;
        if (head.friendID == friendID) return head.next;

        FriendNode current = head;
        while (current.next != null) {
            if (current.next.friendID == friendID) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        System.out.print("👥 Friends of " + user.name + ": ");
        FriendNode temp = user.friends;
        if (temp == null) {
            System.out.println("No friends added.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("❌ One or both users not found!");
            return;
        }

        HashSet<Integer> friendsSet = new HashSet<>();
        FriendNode temp = user1.friends;

        while (temp != null) {
            friendsSet.add(temp.friendID);
            temp = temp.next;
        }

        System.out.print("🔗 Mutual Friends: ");
        boolean found = false;
        temp = user2.friends;
        while (temp != null) {
            if (friendsSet.contains(temp.friendID)) {
                System.out.print(temp.friendID + " ");
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println();
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String nameOrID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(nameOrID) || Integer.toString(temp.userID).equals(nameOrID)) {
                System.out.println("🔍 User Found: " + temp.userID + " - " + temp.name + " (" + temp.age + " years old)");
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ User not found.");
    }

    // Count number of friends for each user
    public void countFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        int count = 0;
        FriendNode temp = user.friends;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println(user.name + " has " + count + " friends.");
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(101, "Alice", 25);
        sm.addUser(102, "Bob", 22);
        sm.addUser(103, "Charlie", 23);
        sm.addUser(104, "David", 24);

        sm.addFriend(101, 102);
        sm.addFriend(101, 103);
        sm.addFriend(102, 103);
        sm.addFriend(103, 104);

        sm.displayFriends(101);
        sm.displayFriends(102);

        sm.findMutualFriends(101, 102);
        sm.findMutualFriends(101, 104);

        sm.countFriends(103);

        sm.searchUser("Alice");
        sm.searchUser("104");

        sm.removeFriend(101, 103);
        sm.displayFriends(101);
    }
}
