
public class Song 
{
	private String title;
	private String artist;
	private int[] time;
	
	public Song(String title, String artist, int[] time) 
	{
		int[] copy = new int[time.length];
		this.title = title;
		this.artist = artist;
		
		//Help from Weston
		for (int i = 0; i < time.length; ++i)
		{
			copy[i] = time[i];
		}
		
		this.time = copy; 
	}

	public String getTitle() 
	{
		return this.title;
	}

	public String getArtist() 
	{
		return this.artist;
	}
 
	public int[] getTime() 
	{
		int[] copy = new int[this.time.length];
		
		for (int i = 0; i < time.length; ++i)
		{
			copy[i] = this.time[i];
		}
	
		return copy;
	}
}

