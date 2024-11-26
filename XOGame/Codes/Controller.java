import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
//    Panes
    @FXML
    private Pane mainPagePane;
    @FXML
    private Pane onePlayerPane;
    @FXML
    private Pane twoPlayersPane;

//    Main Page Pane
    @FXML
    private Button onePlayerButton;
    @FXML
    private Button twoPlayersButton;

//    One Player Pane
    @FXML
    private Label turnLabelOnePlayer;
    @FXML
    private Button btn1onePlayer;
    @FXML
    private Button btn2onePlayer;
    @FXML
    private Button btn3onePlayer;
    @FXML
    private Button btn4onePlayer;
    @FXML
    private Button btn5onePlayer;
    @FXML
    private Button btn6onePlayer;
    @FXML
    private Button btn7onePlayer;
    @FXML
    private Button btn8onePlayer;
    @FXML
    private Button btn9onePlayer;
    private final List<Button> btnListOnePlayer = new ArrayList<>();
    @FXML
    private Button backToMainPageButtonOnePlayer;
    @FXML
    private Button resetToOnePlayerPageButton;
    private int userClickedOnePlayer;
    private final Set<Integer> allUserClicksOnePlayer = new HashSet<>();
    private int computerClickedOnePlayer;
    private final Set<Integer> allComputerClicksOnePlayer = new HashSet<>();
    private final Set<Integer> allChosenSetOnePlayer = new HashSet<>();
    private Random random = new Random();

//    Two Players Pane
    @FXML
    private Label turnLabelTwoPlayers;
    @FXML
    private Button btn1twoPlayers;
    @FXML
    private Button btn2twoPlayers;
    @FXML
    private Button btn3twoPlayers;
    @FXML
    private Button btn4twoPlayers;
    @FXML
    private Button btn5twoPlayers;
    @FXML
    private Button btn6twoPlayers;
    @FXML
    private Button btn7twoPlayers;
    @FXML
    private Button btn8twoPlayers;
    @FXML
    private Button btn9twoPlayers;
    private final List<Button> btnListTwoPlayers = new ArrayList<>();
    @FXML
    private Button backToMainPageButtonTwoPlayers;
    @FXML
    private Button resetToTwoPlayersPageButton;
    private int userClickedTwoPlayers;
    private final Set<Integer> allUserClicksTwoPlayersO = new HashSet<>();
    private final Set<Integer> allUserClicksTwoPlayersX = new HashSet<>();

//    Common
    private boolean mainKey;
    private int allTurnCounter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainKey = true;
        allTurnCounter = 0;

        btnListOnePlayer.add(btn1onePlayer);
        btnListOnePlayer.add(btn2onePlayer);
        btnListOnePlayer.add(btn3onePlayer);
        btnListOnePlayer.add(btn4onePlayer);
        btnListOnePlayer.add(btn5onePlayer);
        btnListOnePlayer.add(btn6onePlayer);
        btnListOnePlayer.add(btn7onePlayer);
        btnListOnePlayer.add(btn8onePlayer);
        btnListOnePlayer.add(btn9onePlayer);
        turnLabelOnePlayer.setText("O: It is your turn!");
        for (int i = 1; i <= 9; i++)
            allChosenSetOnePlayer.add(i);

        btnListTwoPlayers.add(btn1twoPlayers);
        btnListTwoPlayers.add(btn2twoPlayers);
        btnListTwoPlayers.add(btn3twoPlayers);
        btnListTwoPlayers.add(btn4twoPlayers);
        btnListTwoPlayers.add(btn5twoPlayers);
        btnListTwoPlayers.add(btn6twoPlayers);
        btnListTwoPlayers.add(btn7twoPlayers);
        btnListTwoPlayers.add(btn8twoPlayers);
        btnListTwoPlayers.add(btn9twoPlayers);
        turnLabelTwoPlayers.setText("O: It is your turn!");
    }

//    Main Page Pane
    public void eventMainPage(ActionEvent event) {
        if (event.getSource() == onePlayerButton) {
            mainPagePane.setVisible(false);
            onePlayerPane.setVisible(true);
            twoPlayersPane.setVisible(false);
        }
        else if (event.getSource() == twoPlayersButton) {
            mainPagePane.setVisible(false);
            onePlayerPane.setVisible(false);
            twoPlayersPane.setVisible(true);
        }
    }

//    One Player Pane
    public void eventOnePlayerPage(ActionEvent event) {
        if (event.getSource() == btn1onePlayer) {
            userClickedOnePlayer = 1;
            userTurnOnePlayer(btn1onePlayer);
        }
        else if (event.getSource() == btn2onePlayer) {
            userClickedOnePlayer = 2;
            userTurnOnePlayer(btn2onePlayer);
        }
        else if (event.getSource() == btn3onePlayer) {
            userClickedOnePlayer = 3;
            userTurnOnePlayer(btn3onePlayer);
        }
        else if (event.getSource() == btn4onePlayer) {
            userClickedOnePlayer = 4;
            userTurnOnePlayer(btn4onePlayer);
        }
        else if (event.getSource() == btn5onePlayer) {
            userClickedOnePlayer = 5;
            userTurnOnePlayer(btn5onePlayer);
        }
        else if (event.getSource() == btn6onePlayer) {
            userClickedOnePlayer = 6;
            userTurnOnePlayer(btn6onePlayer);
        }
        else if (event.getSource() == btn7onePlayer) {
            userClickedOnePlayer = 7;
            userTurnOnePlayer(btn7onePlayer);
        }
        else if (event.getSource() == btn8onePlayer) {
            userClickedOnePlayer = 8;
            userTurnOnePlayer(btn8onePlayer);
        }
        else if (event.getSource() == btn9onePlayer) {
            userClickedOnePlayer = 9;
            userTurnOnePlayer(btn9onePlayer);
        }

        if (event.getSource() == backToMainPageButtonOnePlayer) {
            resetOnePlayerPage();
            mainPagePane.setVisible(true);
            onePlayerPane.setVisible(false);
        }
        else if (event.getSource() == resetToOnePlayerPageButton) {
            resetOnePlayerPage();
        }
    }

    public void resetOnePlayerPage() {
        for (int i = 0; i < btnListOnePlayer.size(); i++)
            btnListOnePlayer.get(i).setText("");
        turnLabelOnePlayer.setText("O: It is your turn!");
        mainKey = true;
        allTurnCounter = 0;
        allUserClicksOnePlayer.clear();
        allComputerClicksOnePlayer.clear();
        for (int i = 1; i <= 9; i++)
            allChosenSetOnePlayer.add(i);
    }

    public void userTurnOnePlayer(Button btn) {
        if (mainKey) {
            boolean key = false;
            for (Integer i : allUserClicksOnePlayer) {
                if (i == userClickedOnePlayer) {
                    key = true;
                    break;
                }
            }
            for (Integer i : allComputerClicksOnePlayer) {
                if (i == userClickedOnePlayer) {
                    key = true;
                    break;
                }
            }

            if (key)
                turnLabelOnePlayer.setText("This is selected! Try another one!");
            else {
                allUserClicksOnePlayer.add(userClickedOnePlayer);
                btn.setText("O");
                allTurnCounter++;
                allChosenSetOnePlayer.remove(userClickedOnePlayer);
                turnLabelOnePlayer.setText("X: It is computer turn!");
                checkClicksOnePlayer();
                computerTurnOnePlayer();
            }
        }
    }

    public void computerTurnOnePlayer() {
        if (mainKey) {
            while (true) {
                List<Integer> allChosenList = new ArrayList<>(allChosenSetOnePlayer);
                computerClickedOnePlayer = allChosenList.get(random.nextInt(allChosenList.size()));

                boolean key = false;
                for (Integer i : allUserClicksOnePlayer) {
                    if (i == computerClickedOnePlayer) {
                        key = true;
                        break;
                    }
                }
                for (Integer i : allComputerClicksOnePlayer) {
                    if (i == computerClickedOnePlayer) {
                        key = true;
                        break;
                    }
                }

                if (!key) {
                    allComputerClicksOnePlayer.add(computerClickedOnePlayer);
                    btnListOnePlayer.get(computerClickedOnePlayer - 1).setText("X");
                    allTurnCounter++;
                    allChosenSetOnePlayer.remove(computerClickedOnePlayer);
                    turnLabelOnePlayer.setText("O: It is your turn!");
                    checkClicksOnePlayer();
                    break;
                }
            }
        }
    }

    public void checkClicksOnePlayer() {
        if (allUserClicksOnePlayer.contains(1) && allUserClicksOnePlayer.contains(4) && allUserClicksOnePlayer.contains(7) ||
                allUserClicksOnePlayer.contains(2) && allUserClicksOnePlayer.contains(5) && allUserClicksOnePlayer.contains(8) ||
                allUserClicksOnePlayer.contains(3) && allUserClicksOnePlayer.contains(6) && allUserClicksOnePlayer.contains(9) ||
                allUserClicksOnePlayer.contains(1) && allUserClicksOnePlayer.contains(2) && allUserClicksOnePlayer.contains(3) ||
                allUserClicksOnePlayer.contains(4) && allUserClicksOnePlayer.contains(5) && allUserClicksOnePlayer.contains(6) ||
                allUserClicksOnePlayer.contains(7) && allUserClicksOnePlayer.contains(8) && allUserClicksOnePlayer.contains(9) ||
                allUserClicksOnePlayer.contains(1) && allUserClicksOnePlayer.contains(5) && allUserClicksOnePlayer.contains(9) ||
                allUserClicksOnePlayer.contains(3) && allUserClicksOnePlayer.contains(5) && allUserClicksOnePlayer.contains(7)
        ) {
            userWonOnePlayer();
            return;
        }

        if (allComputerClicksOnePlayer.contains(1) && allComputerClicksOnePlayer.contains(4) && allComputerClicksOnePlayer.contains(7) ||
                allComputerClicksOnePlayer.contains(2) && allComputerClicksOnePlayer.contains(5) && allComputerClicksOnePlayer.contains(8) ||
                allComputerClicksOnePlayer.contains(3) && allComputerClicksOnePlayer.contains(6) && allComputerClicksOnePlayer.contains(9) ||
                allComputerClicksOnePlayer.contains(1) && allComputerClicksOnePlayer.contains(2) && allComputerClicksOnePlayer.contains(3) ||
                allComputerClicksOnePlayer.contains(4) && allComputerClicksOnePlayer.contains(5) && allComputerClicksOnePlayer.contains(6) ||
                allComputerClicksOnePlayer.contains(7) && allComputerClicksOnePlayer.contains(8) && allComputerClicksOnePlayer.contains(9) ||
                allComputerClicksOnePlayer.contains(1) && allComputerClicksOnePlayer.contains(5) && allComputerClicksOnePlayer.contains(9) ||
                allComputerClicksOnePlayer.contains(3) && allComputerClicksOnePlayer.contains(5) && allComputerClicksOnePlayer.contains(7)
        ) {
            computerWonOnePlayer();
            return;
        }

        if (allTurnCounter == 9)
            drawOnePlayer();
    }

    public void userWonOnePlayer() {
        turnLabelOnePlayer.setText("You Won!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("You Won!");
        alertUserWon.show();
    }

    public void computerWonOnePlayer() {
        turnLabelOnePlayer.setText("You Lost!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("Computer Won!");
        alertUserWon.show();
    }

    public void drawOnePlayer() {
        turnLabelOnePlayer.setText("Draw!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("Draw!");
        alertUserWon.show();
    }

//    Two Players Pane
    public void eventTwoPlayersPage(ActionEvent event) {
        if (event.getSource() == btn1twoPlayers) {
            userClickedTwoPlayers = 1;
            userTurnTwoPlayers(btn1twoPlayers);
        }
        else if (event.getSource() == btn2twoPlayers) {
            userClickedTwoPlayers = 2;
            userTurnTwoPlayers(btn2twoPlayers);
        }
        else if (event.getSource() == btn3twoPlayers) {
            userClickedTwoPlayers = 3;
            userTurnTwoPlayers(btn3twoPlayers);
        }
        else if (event.getSource() == btn4twoPlayers) {
            userClickedTwoPlayers = 4;
            userTurnTwoPlayers(btn4twoPlayers);
        }
        else if (event.getSource() == btn5twoPlayers) {
            userClickedTwoPlayers = 5;
            userTurnTwoPlayers(btn5twoPlayers);
        }
        else if (event.getSource() == btn6twoPlayers) {
            userClickedTwoPlayers = 6;
            userTurnTwoPlayers(btn6twoPlayers);
        }
        else if (event.getSource() == btn7twoPlayers) {
            userClickedTwoPlayers = 7;
            userTurnTwoPlayers(btn7twoPlayers);
        }
        else if (event.getSource() == btn8twoPlayers) {
            userClickedTwoPlayers = 8;
            userTurnTwoPlayers(btn8twoPlayers);
        }
        else if (event.getSource() == btn9twoPlayers) {
            userClickedTwoPlayers = 9;
            userTurnTwoPlayers(btn9twoPlayers);
        }

        if (event.getSource() == backToMainPageButtonTwoPlayers) {
            resetTwoPlayersPage();
            mainPagePane.setVisible(true);
            twoPlayersPane.setVisible(false);
        }
        else if (event.getSource() == resetToTwoPlayersPageButton) {
            resetTwoPlayersPage();
        }
    }

    public void resetTwoPlayersPage() {
        for (int i = 0; i < btnListTwoPlayers.size(); i++)
            btnListTwoPlayers.get(i).setText("");
        turnLabelTwoPlayers.setText("O: It is your turn!");
        mainKey = true;
        allTurnCounter = 0;
        allUserClicksTwoPlayersO.clear();
        allUserClicksTwoPlayersX.clear();
    }

    public void userTurnTwoPlayers(Button btn) {
        if (mainKey) {
            boolean key = false;
            if (allTurnCounter % 2 == 0) {
                for (Integer i : allUserClicksTwoPlayersO) {
                    if (i == userClickedTwoPlayers) {
                        key = true;
                        break;
                    }
                }
                for (Integer i : allUserClicksTwoPlayersX) {
                    if (i == userClickedTwoPlayers) {
                        key = true;
                        break;
                    }
                }

                if (key)
                    turnLabelTwoPlayers.setText("This is selected! Try another one!");
                else {
                    allUserClicksTwoPlayersO.add(userClickedTwoPlayers);
                    btn.setText("O");
                    allTurnCounter++;
                    turnLabelTwoPlayers.setText("X: It is your turn!");
                    checkClicksTwoPlayers();
                }
            }
            else {
                for (Integer i : allUserClicksTwoPlayersO) {
                    if (i == userClickedTwoPlayers) {
                        key = true;
                        break;
                    }
                }
                for (Integer i : allUserClicksTwoPlayersX) {
                    if (i == userClickedTwoPlayers) {
                        key = true;
                        break;
                    }
                }

                if (key)
                    turnLabelTwoPlayers.setText("This is selected! Try another one!");
                else {
                    allUserClicksTwoPlayersX.add(userClickedTwoPlayers);
                    btn.setText("X");
                    allTurnCounter++;
                    turnLabelTwoPlayers.setText("O: It is your turn!");
                    checkClicksTwoPlayers();
                }
            }
        }
    }

    public void checkClicksTwoPlayers() {
        if (allUserClicksTwoPlayersO.contains(1) && allUserClicksTwoPlayersO.contains(4) && allUserClicksTwoPlayersO.contains(7) ||
                allUserClicksTwoPlayersO.contains(2) && allUserClicksTwoPlayersO.contains(5) && allUserClicksTwoPlayersO.contains(8) ||
                allUserClicksTwoPlayersO.contains(3) && allUserClicksTwoPlayersO.contains(6) && allUserClicksTwoPlayersO.contains(9) ||
                allUserClicksTwoPlayersO.contains(1) && allUserClicksTwoPlayersO.contains(2) && allUserClicksTwoPlayersO.contains(3) ||
                allUserClicksTwoPlayersO.contains(4) && allUserClicksTwoPlayersO.contains(5) && allUserClicksTwoPlayersO.contains(6) ||
                allUserClicksTwoPlayersO.contains(7) && allUserClicksTwoPlayersO.contains(8) && allUserClicksTwoPlayersO.contains(9) ||
                allUserClicksTwoPlayersO.contains(1) && allUserClicksTwoPlayersO.contains(5) && allUserClicksTwoPlayersO.contains(9) ||
                allUserClicksTwoPlayersO.contains(3) && allUserClicksTwoPlayersO.contains(5) && allUserClicksTwoPlayersO.contains(7)
        ) {
            userWonTwoPlayersO();
            return;
        }

        if (allUserClicksTwoPlayersX.contains(1) && allUserClicksTwoPlayersX.contains(4) && allUserClicksTwoPlayersX.contains(7) ||
                allUserClicksTwoPlayersX.contains(2) && allUserClicksTwoPlayersX.contains(5) && allUserClicksTwoPlayersX.contains(8) ||
                allUserClicksTwoPlayersX.contains(3) && allUserClicksTwoPlayersX.contains(6) && allUserClicksTwoPlayersX.contains(9) ||
                allUserClicksTwoPlayersX.contains(1) && allUserClicksTwoPlayersX.contains(2) && allUserClicksTwoPlayersX.contains(3) ||
                allUserClicksTwoPlayersX.contains(4) && allUserClicksTwoPlayersX.contains(5) && allUserClicksTwoPlayersX.contains(6) ||
                allUserClicksTwoPlayersX.contains(7) && allUserClicksTwoPlayersX.contains(8) && allUserClicksTwoPlayersX.contains(9) ||
                allUserClicksTwoPlayersX.contains(1) && allUserClicksTwoPlayersX.contains(5) && allUserClicksTwoPlayersX.contains(9) ||
                allUserClicksTwoPlayersX.contains(3) && allUserClicksTwoPlayersX.contains(5) && allUserClicksTwoPlayersX.contains(7)
        ) {
            userWonTwoPlayersX();
            return;
        }

        if (allTurnCounter == 9)
            drawTwoPlayers();
    }

    public void userWonTwoPlayersO() {
        turnLabelTwoPlayers.setText("O: You Won!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("O Won!");
        alertUserWon.show();
    }

    public void userWonTwoPlayersX() {
        turnLabelTwoPlayers.setText("X: You Won!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("X Won!");
        alertUserWon.show();
    }

    public void drawTwoPlayers() {
        turnLabelTwoPlayers.setText("Draw!");
        mainKey = false;

        Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
        alertUserWon.setTitle("Winner");
        alertUserWon.setHeaderText("Draw!");
        alertUserWon.show();
    }
}
