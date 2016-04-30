var app = angular.module('todoList',[]);

app.controller("listController" , function(){
    this.newtask;
    this.changetask = "";
    this.chk;

    this.listItems = [];
    
    this.additem = function(){
        if(this.newtask.length>0){
                this.listItems.push({text:this.newtask , done:false ,doubleClick:false});
                this.newtask = "";
        }
        else{
            alert("Please fill correctly!");   
        }
    };
    
    this.deleteItem = function(item){
        var index = this.listItems.indexOf(item);
        this.listItems.splice(index,1);
    };
    
    this.doneItem = function(item){
        var index = this.listItems.indexOf(item);
         this.listItems[index].done = !this.listItems[index].done;       
    };
    
    this.deleteAll = function(){

        var i = 0;
        while(i<this.listItems.length){
            //alert(i);
            if(this.listItems[i].done==true){
                this.listItems.splice(i,1);
                i--;
            }
            i++;
        }
    };
    
    this.updateItem = function(item){
       
        var index = this.listItems.indexOf(item);
        var text = this.listItems[index].text;
        var done = this.listItems[index].done;
        var doubleClick = !this.listItems[index].doubleClick;
        this.listItems[index] = {text:text, done:done ,doubleClick:doubleClick};
        this.changetask ="";
    };
    
    this.cancelItem = function(item){
       
        var index = this.listItems.indexOf(item);
        var text = this.listItems[index].text;
        var done = this.listItems[index].done;
        var doubleClick = !this.listItems[index].doubleClick;
        this.listItems[index] = {text:text, done:done ,doubleClick:doubleClick};
        this.changetask ="";
    };
    
    this.changeItem = function(item){
       
        var index = this.listItems.indexOf(item);
        var text = this.listItems[index].text;
        var done = this.listItems[index].done;
        var doubleClick = !this.listItems[index].doubleClick;
        this.listItems[index] = {text:this.changetask, done:done ,doubleClick:doubleClick};
        this.changetask ="";
    };
    
    
});