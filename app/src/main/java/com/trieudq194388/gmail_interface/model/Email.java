package com.trieudq194388.gmail_interface.model;

public class Email {
    private String avatarColor;
    private String accountName;
    private String emailTitle;
    private String emailContent;
    private String time;
    private boolean favEmail;

    public Email() {
    }

    public Email(String avatarColor, String accountName, String emailTitle, String emailContent, String time, boolean favEmail) {
        this.avatarColor = avatarColor;
        this.accountName = accountName;
        this.emailTitle = emailTitle;
        this.emailContent = emailContent;
        this.time = time;
        this.favEmail = favEmail;
    }

    public String getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(String avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isFavEmail() {
        return favEmail;
    }

    public void setFavEmail(boolean favEmail) {
        this.favEmail = favEmail;
    }
}
