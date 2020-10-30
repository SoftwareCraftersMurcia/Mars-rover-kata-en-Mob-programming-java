# Goal
Be able to test printCurrentDate function without changing the method signature.

1. Test the code with doubles using a library.
2. Test the code with doubles created by you.
# Code to test
	public void printCurrentDate() {
		String line = calendar.today().toString();
		printer.printLine(line);
	}
# Learnings

How to use Mockito to generate the doubles.

How to build a Mock and Stub manually.

## Tools
[Mockito](http://mockito.org/)
### Example of spy

    @Test
    public void should_send_an_email() {
        EmailSender sender = mock(EmailSender.class);
        UserRegistration userRegistration = new UserRegistration(sender);

        userRegistration.register();

        verify(sender).send(any());
    }
	
### Example of stub

    @Test
    public void should_success_when_password_is_valid() {
        PasswordValidator passwordValidator = mock(PasswordValidator.class);
        when(passwordValidator.isValid(‘validPassword’)).thenReturn(true);
        UserRegistration userRegistration = new UserRegistration(passwordValidator);

        bool success = userRegistration.register();

        assertTrue(success);
    }

## Authors
Luis Rovirosa [@luisrovirosa](https://www.twitter.com/luisrovirosa)

Jordi Anguela [@jordianguela](https://www.twitter.com/jordianguela)