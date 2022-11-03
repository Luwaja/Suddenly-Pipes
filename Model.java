// Luke James
// 30 September 2022
// Assignment 3 - Model.java
// Function: Create an array of pipes that are placed if a blank area is clicked (also marshals and)

import java.util.ArrayList;

class Model
{
	ArrayList<Pipe> pipeList;

	Model()
	{
		pipeList = new ArrayList<Pipe>();
	}

	public void addPipe(int mx, int my)
	{
		boolean foundPipe = false;
		for(int i = 0; i < pipeList.size(); i++)
		{
			if(pipeList.get(i).clickingOnPreExisting(mx,my) == true) //there's a pipe where mouse clicks
			{
				foundPipe = true;
				pipeList.remove(i);
			}

		}
		if(!foundPipe)
			pipeList.add(new Pipe(mx,my));
		
	}

	Json marshal()
	{
		Json ob = Json.newObject();
		Json tmpList = Json.newList();
		ob.add("pipeList", tmpList);
		for(int i = 0; i < pipeList.size(); i++)
			tmpList.add(pipeList.get(i).marshal());
			return ob;
	}

	void unmarshal(Json ob)
	{
		pipeList = new ArrayList<Pipe>();
		Json tmpList = ob.get("pipeList");
		for(int i = 0; i < tmpList.size(); i++)
			pipeList.add(new Pipe(tmpList.get(i)));
	}

	public void update()
	{
	
	}

}