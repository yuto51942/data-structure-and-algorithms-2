const std = {
    print:function(x){
        if(typeof console !== 'undefined'){
            console.log(x);
        }else if(typeof WScript !== 'undefined'){
            WScript.Echo(x);
        }
    }
};

std.print("OK");
