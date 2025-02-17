package utilities;

import com.github.javafaker.Faker;

public class RandomUtility 
{
	public String fakerUserName()
	{
		Faker faker = new Faker();
		String fakerUserName = faker.name().fullName();
		return fakerUserName;

	}
	public String fakerpassword()
	{
		Faker faker = new Faker();
		String fakerpassword =faker.internet().password();
		return fakerpassword;
	}
	public String fakerFirstName()
	{
		Faker faker = new Faker();
		String fakerFirstName=faker.name().firstName();
		return fakerFirstName;
	}
	public String fakerLastName()
	{
		Faker faker = new Faker();
		String fakerLastName=faker.name().lastName();
		return fakerLastName;
	}
	public String fakerAddress()
	{
		Faker faker = new Faker();
		String fakerAdress= faker.address().buildingNumber();
		return fakerAddress();

	}
	public void fakerCity()
	{
		Faker faker = new Faker();
		String fakerCity =faker.company().name();
	}
	public void fakerDate()
	{
		Faker faker = new Faker();
		faker.date();
	}
	public String fakerFood()
	{
		Faker faker = new Faker();
	String fakerFood = faker.food().ingredient();
	return fakerFood;
	}
}
