
public class Playlist 
{

	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist()
	{
		songs = new Song[MIN_CAPACITY];
	}
	
	public Playlist(int capacity)
	{
		if (capacity < MIN_CAPACITY)
		{
			songs = new Song[MIN_CAPACITY];
		}
		else
		{
			songs = new Song[capacity];
		}
	}
	
	public int getCapacity() 
	{
		return songs.length;
	}

	public int getNumSongs() 
	{
		return numSongs;
	}

	public Song getSong(int i) 
	{
		if ((i < 0) || (i >= numSongs))
		{
			return null;
		}
		return songs[i]; 
	}
	
	public Song[] getSongs() 
	{
		Song[] copy = new Song[numSongs];
		
		for (int i = 0; i < numSongs; ++i)
		{
			copy[i] = songs[i];
		}
		
		return copy;
	}

	//Help from Discord discussion from Koy Wilson
	public boolean addSong(Song song) 
	{
		if (song == null)
		{
			return false;
		}
		for (int i = 0; i < songs.length; i++)
		{
			if (songs[i] == null)
			{
				songs[i] = song;
				numSongs++;
				return true;
			}
		}
		return false;
	}
	
	//Help from Discord discussion Anindya Maiti
	public boolean addSong(int index, Song song)
	{
		if (numSongs == songs.length || (index < 0 || index == numSongs + 1) || song == null)
		{
			return false;
		}
		
		for (int i = numSongs; i > index; i--) 
		{
			songs[i] = songs[i - 1];
		}
		
		songs[index] = song;
		numSongs++;
		
		return true;
	}

	//Help from Discord discussion Khoi Trinh
	public int addSongs(Playlist playlist) 
	{
		if (playlist == null)
		{
			return 0;
		}
		
		int y = playlist.numSongs;
		int songsAdded = 0;
		if ((songsAdded < y) && (getCapacity() - numSongs > 0))
		{
			for (int i = 0; (songsAdded < y) && (getCapacity() - getNumSongs() > 0); ++i)
			{
				addSong(playlist.getSong(i));
				++songsAdded;
			}
			return songsAdded;
		}
		return songsAdded;
	}
		
	public Song removeSong() 
	{
		return this.removeSong(this.numSongs - 1);
	}
	
	//Help from Office Hours 
	public Song removeSong(int index)
	{
		if (index < 0 || index >= numSongs) 
		{
			return null;
		}
		
		Song result = songs[index];
		for (int i = index + 1; i < songs.length - 1; ++i)
		{
			songs[i - 1] = songs[i];	
		}
		
		songs[numSongs - 1] = null;
		numSongs--;
		
		return result;
	}
}
