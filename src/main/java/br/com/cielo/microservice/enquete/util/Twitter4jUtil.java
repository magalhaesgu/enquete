package br.com.cielo.microservice.enquete.util;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter4jUtil {
	
	private static String CONSUMER_KEY = "dvTj75UAL9gzWjdriaFFAySVB";
	private static String CONSUMER_SECRET = "rqJ9zuqwgowT7NRPxSepCaPMzdYp8uAS9upjmp4Jyb7IlcCnSc";
	private static String ACCESS_TOKEN = "1237116085029212162-zq7Ui0TZjOkcEdyTMyWKtEu3m1ZGro";
	private static String ACCESS_TOKEN_SECRET = "FdxcdwZV6RsyUVD8udPHEpty7OFxiWPOaDNSMAXUW7aUh";
	
	public static Status publicarStatus(String mensagem) {
		Status status = null;
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey(CONSUMER_KEY)
			.setOAuthConsumerSecret(CONSUMER_SECRET)
			.setOAuthAccessToken(ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			status = twitter.updateStatus(mensagem);
			return status;
		} catch (TwitterException e) {
			return status;
		}		
	}

}
