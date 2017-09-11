package com.jonycse.dynamic.jasper.example;

public class Person {
	private String name;
	private String email;
	private Contact contact;
	private Account account;

	public Person(){
		this.contact = new Contact();
		this.account = new Account();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
