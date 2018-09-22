//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA FÍSICA
function CarPesFisica(){
    document.getElementById("pesfisica").style.display="block";
    document.getElementById("pesjuridica").style.display="none";
}
//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA JURÍDICA
function CarPesJuridica(){
    document.getElementById("pesfisica").style.display="none";
    document.getElementById("pesjuridica").style.display="block";
}