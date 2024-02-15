player1 = input("Please enter player1's name: ")
player2 = input("Please enter player2's name: ")
while True:
    player1_answer = input(player1 + ", What do you want to choose rock, paper or scissors? ").lower()
    player2_answer = input(player2 + ", What do you want to choose rock, paper or scissors? ").lower()
    if player1_answer == player2_answer:
        print("It's a tie")
    elif player1_answer == 'rock':
        if player2_answer == 'paper':
            print(player2 + " wins!")
        elif player2_answer == 'scissors':
            print(player1 + " wins!")
        else:
            print("Invalid input, try again")
    elif player1_answer == 'paper':
        if player2_answer == 'rock':
            print(player1 + " wins!")
        elif player2_answer == 'scissors':
            print(player2 + " wins!")
        else:
            print("Invalid input, try again")
    elif player1_answer == 'scissors':
        if player2_answer == 'rock':
            print(player2 + " wins!")
        elif player2_answer == 'paper':
            print(player1 + " wins!")
        else:
            print("Invalid input, try again")
    else:
        print("Invalid input, try again")
    repeat = input("Do you want to play again? Yes/No: ").lower()
    if repeat == "yes":
        pass
    elif repeat == "no":
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit
