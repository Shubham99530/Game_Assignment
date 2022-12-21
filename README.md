This application is for the game - Tank Stars, created using LibGDX.
The game implements a two-player (1 vs 1) game mode. The game's objective is for players to face off on flat
terrain, taking turns firing bombs at one another. Players get a limited fuel ration per turn and can 
position themselves for a better shot. They must shoot at one another until one of their tanks is destroyed.

The basic functionality the game supports-

1) The player is allowed to select the power and angle of the trajectory and then fire the shot.
2) Players can choose from 3 tanks before starting the game. 
3) A pause menu allows players to save, resume, or exit to the main menu at any point in the game.

DESIGN PATTERNS APPLIED-
1) Bridge design pattern
2)

WORKING OF THE GAME-
Various java classes have been implemented to make this game application.

1) Game_Assignment: The public class Game_Assignment extends Game. It consists of attributes of types- SpriteBatch, Texture, Shaperender and BitmapFont. The two functions overridden from the Game(superclass) are create() and dispose(). The create() helps to create the objects of the mentioned types.

2) GameScreen: The public class GameScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). The three functions overridden from the ScreenAdapter(superclass) are show(), render() and hide(). The show() function helps us get input from the keyboard. The render() function is used to set the colour and coordinates. This screen represents the main menu of our game.

3) PauseScreen: The public class PauseScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). The three functions overridden from the ScreenAdapter(superclass) are show(), render() and hide(). This screen represents the pause menu of the game.

4) PlayScreen: The public class PlayScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). This screen represents the game's playable screen. 

5) ResumeScreen: The public class ResumeScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). 

6) EndScreen: The public class EndScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). The three functions overridden from the ScreenAdapter(superclass) are show(), render() and hide(). 

7) TankSelectionScreen: The public class TankSelectionScreen extends ScreenApapter. It creates an attribute of type Game_Assignment and is initialised in the parametrised constructor( This is an instance of association). The function getTank() returns a random tank(Type: Texture). The three functions overridden from the ScreenAdapter(superclass) are show(), render() and hide(). 
