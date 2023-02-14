# Lunar_Rover
Idea behind implementation :
LunarController class that will create & use Rover and Map instances.

Map class is a representation of an area we wish to navigate through
The main idea is that there will be a grid style of location within the map.
To that end - the map has a max size. It also has an arraylist of rovers that
are currently on the map.

Rover class is a simple representation of a transport device.
It currently has no more data that a name & id as well as a start / current position,
orientation and map that it's currently in. There's also a log of moves
(represented as an arraylist of moves)
