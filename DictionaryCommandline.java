import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline {
    public static void showAllWords(DictionaryManagement dictionary) {
        System.out.printf("%-5s|%-15s|%-15s\n", "No", "English", "Vietnamese");
        for (int i = 0; i < dictionary.getSize(); i++) {
            System.out.printf("%-5d|%-15s|%-15s\n", i + 1, dictionary.getWord(i).getWordTarget(), dictionary.getWord(i).getWordExplain());
        }
    }
    public static void dictionaryAdvance(DictionaryManagement dictionary) {
        int state = -1;
        Scanner scan = new Scanner(System.in);
        while (state != 0) {
            try {
                switch (state) {
                    case -1: {
                        String welcome = "Welcome to My Application!";
                        String state0 = "[0]  Exit";
                        String state1 = "[1]  Add";
                        String state2 = "[2]  Remove";
                        String state3 = "[3]  Update";
                        String state4 = "[4]  Display";
                        String state5 = "[5]  Look Up";
                        String state6 = "[6]  Search";
                        String state7 = "[7]  Game";
                        String state8 = "[8]  Import from file";
                        String state9 = "[9]  Export to file";
                        String action = "Your action:";
                        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                                welcome, state0, state1, state2, state3, state4, state5, state6, state7, state8, state9, action);
                        state = scan.nextInt();
                        break;
                    }
                    case 1: {
                        System.out.print("\nInsert your new word.\nNew word:");
                        String wordTarget = scan.next();
                        System.out.print("Mean:");
                        scan.skip("\n");
                        String wordExplain = scan.nextLine();
                        Word newWord = new Word(wordTarget, wordExplain);
                        dictionary.addWord(newWord);
                        System.out.print("""
                                New Word added!

                                Do you want to add another word?
                                [0]  Yes
                                [1]  No
                                Your action:""");
                        int addState = scan.nextInt();
                        if (addState != 0) {
                            if (addState != 1) {
                                System.out.print("Action not supported! Return to the main menu.\n\n");
                            }
                            state = -1;
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("\nInsert the word you want to remove.\nWord:");
                        String wordTarget = scan.next();
                        if (dictionary.lookUp(wordTarget) == null || dictionary.lookUp(wordTarget).isEmpty()) {
                            System.out.print("""
                                    Can't find that word in the dictionary!

                                    Do you want to insert another word?
                                    [0]  Yes
                                    [1]  No
                                    Your action:""");
                            int updateState = scan.nextInt();
                            if (updateState != 0) {
                                if (updateState != 1) {
                                    System.out.print("Action not supported! Return to the main menu.\n\n");
                                }
                                state = -1;
                            }
                        } else {
                            List<String> a = dictionary.lookUp(wordTarget);
                            System.out.print("Choose the word you want to remove:\n");
                            for (int i = 0; i < a.size(); i++) {
                                System.out.println("[" + i + "]  " + a.get(i));
                            }
                            System.out.print("Your action:");
                            int pickRemoveState = scan.nextInt();
                            if (0 <= pickRemoveState && pickRemoveState < a.size()) {
                                dictionary.removeWord(a.get(pickRemoveState));
                                System.out.print("""
                                        Word removed!

                                        Do you want to remove another word?
                                        [0]  Yes
                                        [1]  No
                                        Your action:""");
                                int removeState = scan.nextInt();
                                if (removeState != 0) {
                                    if (removeState != 1) {
                                        System.out.print("Action not supported! Return to the main menu.\n\n");
                                    }
                                    state = -1;
                                }
                            } else {
                                System.out.print("Action not supported! Return to the main menu.\n\n");
                                state = -1;
                            }
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("\nInsert the word you want to update.\nWord:");
                        String wordTarget = scan.next();
                        if (dictionary.lookUp(wordTarget) == null || dictionary.lookUp(wordTarget).isEmpty()) {
                            System.out.print("""
                                    Can't find that word in the dictionary!

                                    Do you want to insert another word?
                                    [0]  Yes
                                    [1]  No
                                    Your action:""");
                            int removeState = scan.nextInt();
                            if (removeState != 0) {
                                if (removeState != 1) {
                                    System.out.print("Action not supported! Return to the main menu.\n\n");
                                }
                                state = -1;
                            }
                        } else {
                            List<String> a = dictionary.lookUp(wordTarget);
                            System.out.print("Choose the word you want to remove:\n");
                            for (int i = 0; i < a.size(); i++) {
                                System.out.println("[" + i + "]  " + a.get(i));
                            }
                            System.out.print("Your action:");
                            int pickUpdateState = scan.nextInt();
                            if (0 <= pickUpdateState && pickUpdateState < a.size()) {
                                String wordUpdateTarget = a.get(pickUpdateState);
                                dictionary.removeWord(a.get(pickUpdateState));
                                System.out.print("Insert the update:");
                                String wordUpdateExplain = scan.next();
                                dictionary.addWord(new Word(wordUpdateTarget, wordUpdateExplain));
                                System.out.print("""
                                        Word updated!

                                        Do you want to update another word?
                                        [0]  Yes
                                        [1]  No
                                        Your action:""");
                                int updateState = scan.nextInt();
                                if (updateState != 0) {
                                    if (updateState != 1) {
                                        System.out.print("Action not supported! Return to the main menu.\n\n");
                                    }
                                    state = -1;
                                }
                            } else {
                                System.out.print("Action not supported! Return to the main menu.\n\n");
                                state = -1;
                            }
                        }
                        break;
                    }
                    case 4: {
                        showAllWords(dictionary);
                        System.out.print("""
                                Return to the main menu?
                                [0]  Yes
                                Your action:""");
                        int displayState = scan.nextInt();
                        while (displayState != 0) {
                            System.out.print("""
                                    Action not supported!
                                    Return to the main menu?
                                    [0]  Yes
                                    Your action:""");
                            displayState = scan.nextInt();
                        }
                        state = -1;
                        break;
                    }
                    case 5: {
                        System.out.print("\nInsert word you want to look up:");
                        String wordLookUp = scan.next();
                        List<String> a = dictionary.lookUp(wordLookUp);
                        if (a != null && !a.isEmpty()) {
                            System.out.print("Choose the word you want to look up:\n");
                            for (int i = 0; i < a.size(); i++) {
                                System.out.println("[" + i + "]  " + a.get(i));
                            }
                            System.out.print("Your action:");
                            int pickLookupState = scan.nextInt();
                            if (0 <= pickLookupState && pickLookupState < a.size()) {
                                System.out.print("Vietnamese meaning of your word:" + dictionary.getExplain(a.get(pickLookupState)));
                                System.out.print("""


                                        Do you want to look up another word?
                                        [0]  Yes
                                        [1]  No
                                        Your action:""");
                                int lookupState = scan.nextInt();
                                if (lookupState != 0) {
                                    if (lookupState != 1) {
                                        System.out.print("Action not supported! Return to the main menu.\n\n");
                                    }
                                    state = -1;
                                }
                            } else {
                                System.out.print("Can't find that word\n");
                                System.out.print("""


                                        Do you want to look up another word?
                                        [0]  Yes
                                        [1]  No
                                        Your action:""");
                                int lookupState = scan.nextInt();
                                if (lookupState != 0) {
                                    if (lookupState != 1) {
                                        System.out.print("Action not supported! Return to the main menu.\n\n");
                                    }
                                    state = -1;
                                }
                            }
                        } else {
                            System.out.print("Can't find that word\n");
                            System.out.print("""


                                    Do you want to look up another word?
                                    [0]  Yes
                                    [1]  No
                                    Your action:""");
                            int lookupState = scan.nextInt();
                            if (lookupState != 0) {
                                if (lookupState != 1) {
                                    System.out.print("Action not supported! Return to the main menu.\n\n");
                                }
                                state = -1;
                            }
                        }
                        break;
                    }
                    case 6: {

                        break;
                    }
                    case 7: {

                        break;
                    }
                    case 8: {
                        dictionary.insertFromFile("");
                        state = -1;
                        break;
                    }
                    case 9: {
                        dictionary.dictionaryExportToFile();
                        break;
                    }
                    default: {
                        System.out.print("Action not supported! Return to the main menu.\n\n");
                        state = -1;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                scan.close();
                state = 0;

            } finally {
            }
        }
        System.out.println("See you again!");
    }
}
