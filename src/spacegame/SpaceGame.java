package spacegame;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PApplet;

//this is my cool Space_Game 
//the way you play is you try to make your ship avoid the incoming objects 
//you have three lives in the top left corner 
// 't' resets the game and 'q' quits the game 
// good luck public class Space_Game extends PApplet{ 
// the x axises of the blocks 
public class SpaceGame extends PApplet {
	int blockOne = 800;
	int blockTwo = 600;
	int blockThree = 900;
	int blockFour = 690;
	int blockFive = 500;
	int blockSix = 600;
	int blockOneM = 800;
	int blockTwoM = 600;
	int blockThreeM = 900;
	int blockFourM = 690;
	int blockFiveM = 500;
	int blockSixM = 600;
	int baseRate = 18;
	// the images for the numbers
	PImage Three = loadImage("Three.jpg");
	PImage Two = loadImage("Two.png");
	PImage One = loadImage("One.png");
	// Your lives
	int lives = 3;
	// the score int score;
	// this is so it will only decrease one life per time hit
	int loopNeed = 1;
	int loop;
	// to keep score
	int score = 0;
	// extra life X
	int lifeX = 900;
	// to time when the life will respawn
	int count = 0;
	// the extra life Y
	int lifeY = 10;

	public static void main(String[] args) {
		PApplet.main("Space_Game");

	}

	public void setup() {
		// making the background background(0,0,0);
		size(1920, 920);
		background(0, 0, 0);
	}

	public void draw() {
		// clearing the window
		if (lives > 0) {
			fill(0, 0, 0);
			rect(0, 0, width, height);
			loop = loop + 1;
			// drawing lives
			fill(200, 100, 0);
			if (lives == 3) {
				image(Three, 0, 0, 90, 180);
			} else if (lives == 2) {
				image(Two, 0, 0, 90, 180);
			} else if (lives == 1) {
				image(One, 0, 0, 90, 180);
			}
			// drawing the ship
			fill(250, 250, 250);
			rect(10, mouseY - ((10 * height) / 300), (20 * width) / 700, (20 * height) / 300);
			fill(0, 100, 250);
			rect(10, mouseY - (5 * height) / 300, (20 * width) / 700, (10 * height) / 300);
			fill(0, 0, 0);
			rect(20, mouseY - (3 * height) / 300, (10 * width) / 700, (6 * height) / 300);
			// drawing and moving the objects and extra life
			fill(200, 0, 0);
			rect(blockOne, 0, 10, height / 6);
			rect(blockTwo, height / 6, 10, height / 6);
			rect(blockThree, (height / 6) * 2, 10, height / 6);
			rect(blockFour, (height / 6) * 3, 10, height / 6);
			rect(blockFive, (height / 6) * 4, 10, height / 6);
			rect(blockSix, (height / 6) * 5, 10, height / 6);
			if ((int) (Math.random() * 10) + 1 >= 5) {
				fill(250, 0, 0);
			} else {
				fill(0, 250, 0);
			}
			rect(lifeX, lifeY, 10, 10);
			blockOne = blockOne - blockOneM;
			blockTwo = blockTwo - blockTwoM;
			blockThree = blockThree - blockThreeM;
			blockFour = blockFour - blockFourM;
			blockFive = blockFive - blockFiveM;
			blockSix = blockSix - blockSixM;
			lifeX = lifeX - 2;
			if (blockOne <= 0) {
				blockOne = width;
				score = score + 1;
				blockOneM = (int) (Math.random() * baseRate) + 1;
			}
			if (blockTwo <= 0) {
				blockTwo = width;
				score = score + 1;
				blockTwoM = (int) (Math.random() * baseRate) + 1;
			}
			if (blockThree <= 0) {
				blockThree = width;
				score = score + 1;
				blockThreeM = (int) (Math.random() * baseRate) + 1;
			}
			if (blockFour <= 0) {
				blockFour = width;
				score = score + 1;
				blockFourM = (int) (Math.random() * baseRate) + 1;
			}
			if (blockFive <= 0) {
				blockFive = width;
				score = score + 1;
				blockFiveM = (int) (Math.random() * baseRate) + 1;
			}
			if (blockSix <= 0) {
				blockSix = width;
				score = score + 1;
				blockSixM = (int) (Math.random() * baseRate) + 1;
			}
			// to detect if your ship touches a block
			if (blockSix >= 10 && blockSix <= ((20 * width) / 700) + 10
					&& mouseY + ((10 * height) / 300) >= (height / 6) * 5
					&& mouseY - ((10 * height) / 300) <= (height / 6) * 6 && loop >= loopNeed) {
				loopNeed = (width * 15) / 700;
				loop = 0;
				lives--;
			}
			if (blockFive >= 10 && blockFive <= ((20 * width) / 700) + 10
					&& mouseY + ((10 * height) / 300) >= (height / 6) * 4
					&& mouseY - ((10 * height) / 300) <= (height / 6) * 5 && loop >= loopNeed) {
				loopNeed = 15;
				loop = 0;
				lives--;
			}
			if (blockFour >= 10 && blockFour <= ((20 * width) / 700) + 10
					&& mouseY + ((10 * height) / 300) >= (height / 6) * 3
					&& mouseY - ((10 * height) / 300) <= (height / 6) * 4 && loop >= loopNeed) {
				loopNeed = 15;
				loop = 0;
				lives--;
			}
			if (blockThree >= 10 && blockThree <= ((20 * width) / 700) + 10
					&& mouseY + ((10 * height) / 300) >= (height / 6) * 2
					&& mouseY - ((10 * height) / 300) <= (height / 6) * 3 && loop >= loopNeed) {
				loopNeed = 15;
				loop = 0;
				lives--;
			}
			if (blockTwo >= 10 && blockTwo <= ((20 * width) / 700) + 10
					&& mouseY + ((10 * height) / 300) >= (height / 6)
					&& mouseY - ((10 * height) / 300) <= (height / 6) * 2 && loop >= loopNeed) {
				loopNeed = 15;
				loop = 0;
				lives--;
			}
			if (blockOne >= 10 && blockOne <= ((20 * width) / 700) + 10 && mouseY + ((10 * height) / 300) >= 0
					&& mouseY - ((10 * height) / 300) <= (height / 6) && loop >= loopNeed) {
				loopNeed = 15;
				loop = 0;
				lives--;
			}
		}
		// checking to see if your lives are at 0
		if (lives <= 0) {
			// telling you your score
			// the lives thing is just a way to make it not print this a
			// thousand times
			fill(250, 0, 0);
			rect(0, 0, width, height);

			fill(250, 250, 250);
			textSize(150);
			text("Your score was " + score, width / 3, height / 3, width / 2, height / 2);

		}
		if (lives > 0) {
			// updating the count
			count++;
			// what will happen if a extra life reaches the end
			if (count >= 1000 && lifeX <= 0) {
				lifeX = 700;
				lifeY = (int) (Math.random() * height + 1);
			}
			// what will happen if you hit the extra life
			if (lifeX >= 10 && lifeX <= ((20 * width) / 700) + 10 && mouseY + ((10 * height / 300)) >= lifeY
					&& mouseY - ((10 * height / 300)) <= lifeY + 10 && lives < 3) {
				lives++;
				lifeX = -1;
			}
		}
	}

	public void keyPressed() {
		// checking for t or q during the game to reset or quit
		if (key == 't') {
			blockOne = 800;
			blockTwo = 600;
			blockThree = 900;
			blockFour = 690;
			blockFive = 500;
			blockSix = 600;
			lives = 3;
			loopNeed = 1;
			loop = 0;
			score = 0;
			lifeX = -1;
		} else if (key == 'q') {
			System.exit(0);
		}
	}
}
