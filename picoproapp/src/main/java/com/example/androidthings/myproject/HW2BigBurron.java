package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class HW2BigBurron extends SimplePicoPro {
    int row = 9;
    int column = 9;
    int cha_z = 0;
    int cha_sp = 0;
   // boolean completed = false;

    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        pinMode(GPIO_37,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);

        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);

        pinMode(GPIO_34,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_34,Gpio.EDGE_BOTH);

        //set GPIOs input for row selection
        pinMode(GPIO_33,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_33,Gpio.EDGE_BOTH);

        pinMode(GPIO_32,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_32,Gpio.EDGE_BOTH);

        pinMode(GPIO_10,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_10,Gpio.EDGE_BOTH);

        // Need Pull up resisters
        pinMode(GPIO_172,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_172,Gpio.EDGE_BOTH);

        pinMode(GPIO_173,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_173,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
        //nothing to do here

    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
       // char lett [];

        char [][]alphabet = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'}
        };




       // char[][] alphabet = new char[5][5]; // new array
       // char ch = 'a';
        //for (int r = 1; r <=5;++r) {
        //]''
         //   for (int c = 1; c <= 5; ++c)// fills alphabet array with the alphabet
         //   {
        //        alphabet[r;c] = ch;
         //   }
        //}


        // if GPIO == ArowPIN: row = rowID
        // if GPIO == aColPin: col = colID, completed = True
        // if completed == True: print(letters[row][column]), completed = false

        // two key combos for space
       // if ((pin == GPIO_128 && value == HIGH)&&(column == 1)) {
               // printCharacterToScreen(' ');
        //        row = 9;
         //       column = 9;
         //   printCharacterToScreen(' ');
        //} else if ((pin == GPIO_39 && value == HIGH)&&(column == 0)) {
         //       printCharacterToScreen(' ');
          //      row = 9;
          //      column = 9;
        //}
        // two key combos for z
        if ((pin == GPIO_35 && value == HIGH)&&(column == 4)) {
            printCharacterToScreen('z');
            row = 9;
            column = 9;
        } else if ((pin == GPIO_34 && value == HIGH)&&(column == 3)) {
            printCharacterToScreen('z');
            row = 9;
            column = 9;
        }
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
            if (pin == GPIO_128 && value == HIGH) {
                if (column == 1) {
                    // printCharacterToScreen(' ');
                    row = 9;
                    column = 9;
                    printCharacterToScreen(' ');
                } else {
                    column = 0;
                    if (row >= 0 && row <= 4) {
                        printCharacterToScreen(alphabet[row][column]);
                        row = 9;
                        column = 9;
                    }
                }
            } else if (pin == GPIO_39 && value == HIGH) {
                if (column == 0) {
                    printCharacterToScreen(' ');
                    row = 9;
                    column = 9;
                } else {
                    column = 1;
                    if (row >= 0 && row <= 4) {
                        printCharacterToScreen(alphabet[row][column]);
                        row = 9;
                        column = 9;
                    }
                }
            } else if (pin == GPIO_37 && value == HIGH) {
                column = 2;
                if (row >= 0 && row <= 4) {
                    printCharacterToScreen(alphabet[row][column]);
                    row = 9;
                    column = 9;
            }
            } else if (pin == GPIO_35 && value == HIGH) {
                column = 3;
                if (row >= 0 && row <= 4) {
                    printCharacterToScreen(alphabet[row][column]);
                    row = 9;
                    column = 9;
                }
            } else if (pin == GPIO_34 && value == HIGH) {
                column = 4;
                if (row >= 0 && row <= 4) {
                    printCharacterToScreen(alphabet[row][column]);
                    row = 9;
                    column = 9;
                }
            }

             // for rows
        if (pin == GPIO_33 && value == HIGH) {
            row = 0;
            if (column >= 0 && column <= 4) {
                printCharacterToScreen(alphabet[row][column]);
                row = 9;
                column = 9;
            }
        } else if (pin == GPIO_32 && value == HIGH) {
            row = 1;
            if (column >= 0 && column <= 4) {
                printCharacterToScreen(alphabet[row][column]);
                row = 9;
                column = 9;
            }
        } else if (pin == GPIO_10 && value == HIGH) {
            row = 2;
            if (column >= 0 && column <= 4) {
                printCharacterToScreen(alphabet[row][column]);
                row = 9;
                column = 9;
            }
        } else if (pin == GPIO_172 && value == HIGH) {
            row = 3;
            if (column >= 0 && column <= 4) {
                printCharacterToScreen(alphabet[row][column]);
                row = 9;
                column = 9;
            }
        } else if (pin == GPIO_173 && value == HIGH) {
            row = 4;
            if (column >= 0 && column <= 4) {
                printCharacterToScreen(alphabet[row][column]);
                row = 9;
                column = 9;
            }
        }



            //when 39 goes from HIGH to HIGH
           // else if (pin == GPIO_39 && value == HIGH) {
            //    printCharacterToScreen('b');
           // }
            //when 37 goes from HIGH to HIGH
           // else if (pin == GPIO_37 && value == HIGH) {
            //    printCharacterToScreen('c');
                //when 37 goes from HIGH to HIGH
           // } else if (pin == GPIO_35 && value == HIGH) {
            //    printCharacterToScreen('d');
            //}
            //when 37 goes from HIGH to HIGH
           // else if (pin == GPIO_34 && value == HIGH) {
            //    printCharacterToScreen('e');
            //}

       // }
    }

}


