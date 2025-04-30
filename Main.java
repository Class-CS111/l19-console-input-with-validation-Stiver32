import java.util.Arrays;
import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		Scanner netflixInput = new Scanner(System.in);
		NetflixOriginal[] shows = new NetflixOriginal[2];

		for(int i = 0; i < shows.length; ++i)
		{
			shows[i] = instantiateFromInput(netflixInput);
		}

		for (NetflixOriginal show : shows)
		{
			System.out.println(show);
		}
	}

	public static NetflixOriginal instantiateFromInput(Scanner netflixInput)
	{
		//prompt for input name
		
		//prompt for input genre //set when valid (loop)
		
		NetflixOriginal show = new NetflixOriginal();

		System.out.print("Please enter name of show: ");
		String name = netflixInput.nextLine();
		show.setName(name);

		//prompt for input star rating //set when valid (loop)
		boolean validRating = false; // 0

		while(!validRating)
		{
			System.out.print("Enter star rating: ");
			try
			{
				double rating = Double.parseDouble(netflixInput.nextLine());
				validRating = show.setStarRating(rating);
				if(!validRating)
				{
					System.out.println("Rating must be between 0 and 5");
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid input. enter numberic value");
			}

		}

		boolean validGenre = false;
		while(!validGenre)
		{
			System.out.print("Enter genre: ");
			String genre = netflixInput.nextLine();
			validGenre = show.setGenre(genre);
			if(!validGenre)
			{
				System.out.println("Invalid genre. Valid options are:");
				System.out.println(Arrays.toString(NetflixOriginal.VALID_GENRES));

			}
		}
		
		return show;
	}


}