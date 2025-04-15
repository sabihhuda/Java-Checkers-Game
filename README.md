# Checkers Game - Java Implementation

A console-based Checkers game implemented in Java, allowing two players to take turns making moves. The game validates moves, handles piece jumps, and promotes pieces to kings upon reaching the opposite end of the board.

## Features
- **Turn-based gameplay**: Alternate between Black (`b`) and White (`w`) pieces.
- **Move validation**: Ensures moves follow Checkers rules (diagonal movement, mandatory jumps).
- **Jump mechanics**: Supports capturing opponent pieces using `x` (e.g., `5x9`).
- **King promotion**: Promotes pieces to kings (`B` or `W`) when reaching the opponent's end row.
- **Visual board**: Prints the updated board state after each move.
- **Input validation**: Prevents invalid moves and prompts for retries.
- **Cross-platform**: Runs on any system with Java 18+.

## Getting Started
### Prerequisites
- Java JDK 18 or later
- Terminal or IDE (IntelliJ recommended)

### Installation
1. **Clone the repository**:
   ```bash
   git clone [your-repository-url]
   cd checkers-game
Compile and run (via terminal):

bash
Copy
javac project.java
java project
For IntelliJ users: Import the project using the finalproject.iml file.

Game Rules
Starting Player: Choose Black/B or White/W when prompted.

Move Input:

Normal move: Enter positions as start-end (e.g., 9-13).

Jump move: Use x to capture (e.g., 5x9 for a single jump).

Valid Moves:

Regular pieces move diagonally forward.

Kings (B/W) can move diagonally backward and forward.

Jumps are mandatory if possible. Consecutive jumps in one turn are allowed.

Winning: Capture all opponent pieces or block their moves.

Example Gameplay
Copy
Black or White to start
Black
Enter how many moves to make
2
Enter the moves to make
9-13

[Board Display]
        b-b-b-b--b-b-b-b       .-.-.-.--.-.-.-.
        .-b-b-b--b-b-b-.       .-.-.-.--.-.-.-.
        .-.-.-.--.-.-.-.       .-.-.-.--.-.-.-.
        w-w-w-w--w-w-w-w       .-.-.-.--.-.-.-.

5x9

[Board After Jump]
        b-b-b-b--b-b-b-b       .-.-.-.--.-.-.-.
        .-.-.-.--b-b-b-.       .-.-.-.--.-.-.-.
        .-.-w-.--.-.-.-.       .-.-.-.--.-.-.-.
        w-w-w-w--w-w-w-w       .-.-.-.--.-.-.-.
Project Structure
project.java: Core game logic and console interface.

Configuration Files:

finalproject.iml: IntelliJ module configuration.

*.xml: IDE settings for inspections, UI, and project structure.

.gitignore: Excludes IDE-specific files and build outputs.

Troubleshooting
Invalid Move: The game will prompt you to retry.

Java Version Issues: Ensure JDK 18 is installed and set as the project SDK in IntelliJ.

Board Display Glitches: Resize your terminal window if alignment breaks.

Contributing
Fork the repository.

Create a feature branch (git checkout -b feature/improvement).

Test your changes thoroughly.

Submit a pull request with a clear description of enhancements.

License
Distributed under the MIT License. See LICENSE (to be added) for details.

Enjoy the game! 🏁
Developed by [Your Name]
For questions or feedback, open an issue in the repository.
