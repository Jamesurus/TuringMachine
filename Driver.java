public class Driver {
    private TuringMachine a;
    private UniversalTuringMachine b;
    private Move left;
    private Move right;
    //private boolean isanimation;

    public Driver(TuringMachine a,UniversalTuringMachine b,String theTape,Move left,Move right,boolean isanimation) {
        b.loadTuringMachine(a);
        b.loadInput(theTape);
        b.display();
        char array[] = theTape.toCharArray();
        System.out.println(a.getHead().getCurrentCell());
        while (a.getHead().getCurrentCell() < 20 && a.getHead().getCurrentCell() >= 0){
            for(int count2=0;count2<a.getRules().length;count2++){
                if(a.getRules()[count2][0].equals(a.getHead().getCurrentState()) && a.getRules()[count2][1].charAt(0)==(array[a.getHead().getCurrentCell()]))
                {
                    a.getHead().setCurrentState(a.getRules()[count2][2]);
                    b.writeOnCurrentCell(a.getRules()[count2][3].charAt(0));
                    array[a.getHead().getCurrentCell()]=a.getRules()[count2][3].charAt(0);
                    if(a.getRules()[count2][4].equals("LEFT")){
                            b.moveHead(left,isanimation);//True or false
                    }else{
                            b.moveHead(right,isanimation);
                    }
                    if(a.getHead().getCurrentState().equals("qa")){
                        b.displayHaltState(HaltState.ACCEPTED);
                    }else if(a.getHead().getCurrentState().equals("qr")){
                        b.displayHaltState(HaltState.REJECTED);
                    }
                }
            }
        }
    }
}
