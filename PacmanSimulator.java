import java.util.*;
public class PacmanSimulator
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int  x=0,y=0;
	    int x_count=5, y_count=5;
	    String face ="";
	    String currentFacing="";
	    String command;
	    boolean flag= true;
	    boolean start = true;
	    while(flag)
	    {
	        
	    
    	    String choice = s.nextLine();
    	    int spaceIndex = choice.indexOf(" ");
    	    int firstIndex = choice.indexOf(",");
    	    if(!(choice.contains("PLACE") || choice.contains("MOVE") || choice.contains("LEFT") ||
    	    choice.contains("RIGHT") || choice.contains("REPORT")))
    	    {
    	        System.out.println("INVALID COMMAND");
    	        return;
    	    }
    	    if(spaceIndex == -1 &&  choice.contains("PLACE"))
    	    {
    	        System.out.println("INCOMPLETE COMMAND");
    	        return;
    	    }
    	    if(spaceIndex != -1 &&  choice.contains("PLACE"))
    	    {
    	        command = choice.substring(0,spaceIndex);
    	        x = Integer.parseInt(choice.substring(spaceIndex+1,choice.indexOf(",")));
    	    }
    	    else{
    	     command = choice;   
    	    }
    	    
    	    if(firstIndex != -1 &&  choice.contains("PLACE"))
    	    {
        	    y = Integer.parseInt(choice.substring(firstIndex+1,choice.indexOf(",",firstIndex+1)));
    	        face = choice.substring(choice.lastIndexOf(",")+1);
                
    	    }
    	    
    	    
    	    if(start && command.equalsIgnoreCase("PLACE") == false)
    	    {
    	        System.out.println("Starting Command must be equal to 'PLACE'");
    	        flag=false;
    	    }
    	
    	    switch(command.toUpperCase())
    	    {
    	        case "PLACE":
    	            currentFacing = face;
    	            break;
    	        case "MOVE":
    	            if(currentFacing.equalsIgnoreCase("NORTH"))
    	                y++;
    	            else if(currentFacing.equalsIgnoreCase("SOUTH"))
    	                 y--;
    	            else if(currentFacing.equalsIgnoreCase("WEST"))
    	                 x--;
    	            else if(currentFacing.equalsIgnoreCase("EAST"))
    	                 x++;
    	                 
    	           if((y>=y_count || y<0) && currentFacing.equalsIgnoreCase("NORTH") )
    	            {
    	                System.out.println("NOT ENOUGH MOVE");
    	                return;
    	            }
    	            if((x>=x_count || x<0) && currentFacing.equalsIgnoreCase("EAST") )
    	            {
    	                System.out.println("NOT ENOUGH MOVE");
    	                return;
    	            }
    	            if((y>=y_count || y<0) && currentFacing.equalsIgnoreCase("SOUTH") )
    	            {
    	                System.out.println("NOT ENOUGH MOVE");
    	                return;
    	            }
    	            if((x>=x_count || x<0) && currentFacing.equalsIgnoreCase("WEST") )
    	            {
    	                System.out.println("NOT ENOUGH MOVE");
    	                return;
    	            }
    	            break;
	            case "LEFT":
	                if(currentFacing.equalsIgnoreCase("NORTH"))
	                    currentFacing="WEST";
	                else if(currentFacing.equalsIgnoreCase("SOUTH"))
	                    currentFacing="EAST";
	                else if(currentFacing.equalsIgnoreCase("EAST"))
	                    currentFacing="NORTH";
                    else if(currentFacing.equalsIgnoreCase("WEST"))
	                    currentFacing="SOUTH";
	                
	            break;
	            case "RIGHT":
	                if(currentFacing.equalsIgnoreCase("NORTH"))
	                    currentFacing="EAST";
	                else if(currentFacing.equalsIgnoreCase("SOUTH"))
	                    currentFacing="WEST";
	                else if(currentFacing.equalsIgnoreCase("EAST"))
	                    currentFacing="SOUTH";
                    else if(currentFacing.equalsIgnoreCase("WEST"))
	                    currentFacing="NORTH";
	                
	            break;
    	    }
    	    if(choice.equalsIgnoreCase("Report"))
    	    {
                flag = false;     
    	    }
    	    start=false;
	    }
	    System.out.println("output :" + x + "," + y + "," + currentFacing);
    }
}