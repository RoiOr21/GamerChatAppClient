package com.example.gamerchatapp.dm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Body implements Parcelable {
    private User user;
    private User friend;
    private Game game;
    private ChatRoom chatRoom;
    private Messages message;
    private ArrayList<User> userList;
    private ArrayList<User> usersRs;
    private ArrayList<Game> gameList;
    private ArrayList<ChatRoom> chatList;
    private ArrayList<Messages> messageList;
    private String pattern;

    public Body() {
        this.user = new User();
        this.friend = new User();
        this.game = new Game();
        this.chatRoom = new ChatRoom();
        this.message = new Messages();
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.messageList = new ArrayList<>();
        this.usersRs = new ArrayList<>();
        this.pattern = "";
    }

    public Body(User user, String pattern) {
        this.user = user;
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.messageList = new ArrayList<>();
        this.usersRs = new ArrayList<>();
        this.pattern = pattern;
    }

    public Body(User user, Game game, ChatRoom chatRoom, String pattern) {
        this.user = user;
        this.game = game;
        this.chatRoom = chatRoom;
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.messageList = new ArrayList<>();
        this.usersRs = new ArrayList<>();
        this.pattern = pattern;
    }

    public Body(User user, Game game, ChatRoom chatRoom, Messages message, String pattern) {
        this.user = user;
        this.game = game;
        this.chatRoom = chatRoom;
        this.message = message;
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.messageList = new ArrayList<>();
        this.usersRs = new ArrayList<>();
        this.pattern = pattern;
    }

    public Body(User user, User friend, Game game, ChatRoom chatRoom, Messages message, String pattern) {
        this.user = user;
        this.friend = friend;
        this.game = game;
        this.chatRoom = chatRoom;
        this.message = message;
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.messageList = new ArrayList<>();
        this.usersRs = new ArrayList<>();
        this.pattern = pattern;
    }

    protected Body(Parcel in) {
        this.user = in.readParcelable(User.class.getClassLoader());
        this.friend = in.readParcelable(User.class.getClassLoader());
        this.game = in.readParcelable(Game.class.getClassLoader());
        this.chatList = in.readParcelable(ChatRoom.class.getClassLoader());
        this.message = in.readParcelable(Messages.class.getClassLoader());
        this.userList = in.readArrayList(ArrayList.class.getClassLoader());
        this.gameList = in.readArrayList(ArrayList.class.getClassLoader());
        this.chatList = in.readArrayList(ArrayList.class.getClassLoader());
        this.messageList = in.readArrayList(ArrayList.class.getClassLoader());
        this.usersRs = in.readArrayList(ArrayList.class.getClassLoader());
        this.pattern = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.user, flags);
        dest.writeParcelable((Parcelable) this.friend, flags);
        dest.writeParcelable((Parcelable) this.game, flags);
        dest.writeParcelable((Parcelable) this.chatRoom, flags);
        dest.writeParcelable((Parcelable) this.message, flags);
        dest.writeList(this.userList);
        dest.writeList(this.gameList);
        dest.writeList(this.chatList);
        dest.writeList(this.messageList);
        dest.writeList(this.usersRs);
        dest.writeString(this.pattern);
    }

    public static final Creator<Body> CREATOR = new Creator<Body>() {
        @Override
        public Body createFromParcel(Parcel in) {
            return new Body(in);
        }

        @Override
        public Body[] newArray(int size) {
            return new Body[size];
        }
    };

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Messages getMessage() {
        return message;
    }

    public void setMessage(Messages message) {
        this.message = message;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> getUsersRs() {
        return usersRs;
    }

    public void setUsersRs(ArrayList<User> usersRs) {
        this.usersRs = usersRs;
    }

    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }

    public ArrayList<ChatRoom> getChatList() {
        return chatList;
    }

    public void setChatList(ArrayList<ChatRoom> chatList) {
        this.chatList = chatList;
    }

    public ArrayList<Messages> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Messages> messageList) {
        this.messageList = messageList;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Body{" +
                "user=" + user +
                ", friend=" + friend +
                ", game=" + game +
                ", chatRoom=" + chatRoom +
                ", message=" + message +
                ", userList=" + userList +
                ", usersRs=" + usersRs +
                ", gameList=" + gameList +
                ", chatList=" + chatList +
                ", messageList=" + messageList +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
