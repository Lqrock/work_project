$(document).ready(function () {
  $('#dtHorizontalExample').DataTable({
    "scrollX": true
  });
  $('.dataTables_length').addClass('bs-select');
});

function getVehicle(){
    var id = vehicleId.value;
    document.getElementById("showVehicle").href="http://localhost:8080/vehicle/get/" + id;
}

function getVehicleID(x) {
    let row = x.rowIndex;
    let col = 0;
    let Cell = document.getElementById('dtHorizontalExample').rows[row].cells;
    var id = Cell[col].innerHTML;
    document.getElementById("vehicleId").value=id;
}


function getAccommodation(){
    var id = accommodationId.value;
    document.getElementById("showAccommodation").href="http://localhost:8080/accommodation/get/" + id;
}

function getAccommodationID(x) {
    let row = x.rowIndex;
    let col = 0;
    let Cell = document.getElementById('dtHorizontalExample').rows[row].cells;
    var id = Cell[col].innerHTML;
    document.getElementById("accommodationId").value=id;
}

function getEmployee(){
    var id = employeeId.value;
    document.getElementById("showEmployee").href="http://localhost:8080/employee/get/" + id;
}

function getEmployeeID(x) {
    let row = x.rowIndex;
    let col = 0;
    let Cell = document.getElementById('dtHorizontalExample').rows[row].cells;
    var id = Cell[col].innerHTML;
    document.getElementById("employeeId").value=id;
}

function getProject(){
    var id = projectId.value;
    document.getElementById("showProject").href="http://localhost:8080/project/get/" + id;
}

function getProjectID(x) {
    let row = x.rowIndex;
    let col = 0;
    let Cell = document.getElementById('dtHorizontalExample').rows[row].cells;
    var id = Cell[col].innerHTML;
    document.getElementById("projectId").value=id;
}


function getTimesheet(){
    var id = timesheetId.value;
    document.getElementById("showTimesheet").href="http://localhost:8080/timesheet/get/" + id;
}

function getTimesheetID(x) {
    let row = x.rowIndex;
    let col = 0;
    let Cell = document.getElementById('dtHorizontalExample').rows[row].cells;
    var id = Cell[col].innerHTML;
    document.getElementById("timesheetId").value=id;
}



window.addEventListener('DOMContentLoaded', event=>{

    // check mikone age scrollY 0 bashe navbar-shrink ro ke ye classe css e remove mikone az classe nav-main,
    // age 0 nabashe yani safhe scroll khorde dar natije range navbar o avaz mikone ( add mikone navbar shrink o va classe css change mide rangesho)


    var navbarShrink = function(){
        const navbarCollapsible = document.body.querySelector("#nav-main");
        if(!navbarCollapsible){
            return;
        }

        if(window.scrollY===0){
            navbarCollapsible.classList.remove('navbar-shrink')
            navbarCollapsible.classList.remove('bg-blackColor')
        }else{
            navbarCollapsible.classList.add('navbar-shrink')
        }
        if(window.scrollY>= 1360){
            navbarCollapsible.classList.remove('navbar-shrink')
            navbarCollapsible.classList.remove('bg-coolColor')
            navbarCollapsible.classList.add('bg-blackColor')
        }
    };

       // method balayio ye bar run mikone vaqti safhe baz mishe ke motmaen she scroll nakhorde va state e nav-main ro set mikone. ke shrinke ya na
    navbarShrink();

    // navbar ro shrink mikone vaqti page scroll mishe

    document.addEventListener('scroll', navbarShrink);
    var test = function(){
        if(window.scrollY>1200){
            console.log(window.scrollY)
        }
    }
    // document.addEventListener('scroll', test);

    // ino az net copy kardam nemidonam chie :|
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#rps-navbar .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });


});