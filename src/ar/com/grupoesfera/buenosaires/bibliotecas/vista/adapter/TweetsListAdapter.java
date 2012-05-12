package ar.com.grupoesfera.buenosaires.bibliotecas.vista.adapter;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroTweet;

//TODO: Modificar por una que extienda de BaseAdapter, para poder manipular la lista.
public class TweetsListAdapter extends ArrayAdapter<LibroTweet> { 
	
	private Context context;
	private static SimpleDateFormat sdf;

	public TweetsListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		this.context = context;
		
		TweetsListAdapter.sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.tweets_item, null);
		}

		LibroTweet tweet = this.getItem(position);
		
		if(tweet != null) {
			
			TextView author = (TextView) view.findViewById(R.id.TweetAuthor);
			TextView text = (TextView) view.findViewById(R.id.TweetText);
			TextView date = (TextView) view.findViewById(R.id.TweetDate);
			ImageView image = (ImageView) view.findViewById(R.id.TweetProfileImage);

			if(author != null) {
				
				author.setText( "@" + tweet.getUser() );
			}
			
			if(text != null) {
				
				text.setText( tweet.getText() );
			}
			
			if(date != null && tweet.getDateCreated() != null) {
				
				date.setText(sdf.format( tweet.getDateCreated() ));
			}
			
			if(image != null) {
				
				image.setImageDrawable( tweet.getProfileImage() );
			}

//			view.getBackground().setLevel(position % 2);

		}
		return view;
	}
}