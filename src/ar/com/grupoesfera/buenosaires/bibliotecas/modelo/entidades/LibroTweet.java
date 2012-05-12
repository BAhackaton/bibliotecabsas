package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class LibroTweet {
	
	private static final String LOG_TAG = LibroTweet.class.getSimpleName();

	private String user;
	private Drawable profileImage;
	private String text;
	private Date dateCreated;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Drawable getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImageUrl(String url) throws MalformedURLException, IOException { 
		try {
			InputStream is = (InputStream) new URL(url).getContent();
			profileImage = Drawable.createFromStream(is,"src");
		} catch (Exception e) {
			Log.e( LOG_TAG ,"Error descargando la imagen de perfil del usuario", e);
		}
	}
	
	public void setProfileImageUrl(Drawable imagen) { 
		this.profileImage = imagen;
	}

}