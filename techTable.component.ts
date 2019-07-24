import { Component, OnInit } from '@angular/core';
import { DatePipe }  from '@angular/common'
import { FormBuilder, FormGroup, Validators ,FormControl} from '@angular/forms';
import { NgbProgressbarConfig, NgbTabChangeEvent, NgbModal ,NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Router ,ActivatedRoute, ParamMap} from '@angular/router';
import { TechTableService } from './techTable.servise';
import { TechTable } from './techTable';
import { TechTableDet } from './techTableDet';

const my=new Date();
@Component({
  templateUrl: './techTable.component.html',
  styleUrls: ['./techTable.component.css']
})


export class TechTableComponent implements OnInit {

    techTable: Array<TechTable> = [];
    TableDetalle : Array<TechTableDet> = [];

    errorMessage: any;
    detTable : TechTableDet = new TechTableDet();
    insertTable:TechTable = new TechTable();
   
    updateTableForm:FormGroup;

    updateTable:TechTable = new TechTable();
    respUpd:boolean;
    subUpd= false;
    insertTableForm:FormGroup;

    subInsert = false;
    respInser:boolean;
    respuesta:string;

    
 
  modalDate: NgbDateStruct= {
    day: my.getDate(),
    month: my.getMonth() + 1,
    year: my.getFullYear()
  };  
  
  
    constructor(public router: Router , private service:TechTableService, 
        private modalService: NgbModal,private formBuilder: FormBuilder)
        {
    
        }
    
    ngOnInit() {
      
      this.listTablas();

        this.insertTableForm = this.formBuilder.group({

            tableId : ['', Validators.required],
            descripcion: ['', Validators.required],
            descripcionUno:  ['', Validators.required],
            descripcionNroUno: ['', Validators.required],
            descripcionDos: ['',Validators.required],
            descripcionNroDos: ['',Validators.required],
            descripcionTres: ['',Validators.required],
            descripcionNroTres: ['',Validators.required],
            createdDate: ['',Validators.required],
            createdBy: ['',Validators.required],
            
            
         
        }); 

    }
    
   listTablas(){ this.service.getList().subscribe(
      datos=> {
      console.log(datos);
        this.techTable=datos;
    },
    error=>{
    console.log("miError: "+this.errorMessage);
    this.errorMessage=<any>error;
    });
  }
      

      get i() { return this.insertTableForm.controls; }

    insertar() {
      
      
      
      this.insertTable.createdDate=new Date(this.modalDate.year,this.modalDate.month, this.modalDate.day);
      

    this.subInsert = true;
      if (this.insertTableForm.invalid) {
        this.respInser=false;
        return;
      }
      this.modalDate={
        day: new Date(this.insertTable.createdDate).getDate(),
        month:new Date(this.insertTable.createdDate).getMonth() + 1,
        year: new Date(this.insertTable.createdDate).getFullYear(),
      };
      console.log(this.insertTable);
      
      this.service.getInsertarTable(this.insertTable).subscribe(
        
        respInser=> {
          console.log(respInser);
          this.respInser=respInser;
          if(respInser){
            this.respuesta='Se inserto registro satisfactoriamente';
            this.listTablas();
          }else{
            this.respuesta='Hubo un problema interno por favor intente en otro momento';
            this.listTablas();
          }
        },
      error=>{
      console.log("miError: "+this.errorMessage);
      this.errorMessage=<any>error;
      });
    }


    open(content:any,tableId:string){

          
  
        this.updateTableForm = this.formBuilder.group({

        
            tableId : ['', Validators.required],
            descripcion: ['', Validators.required],
            descripcionUno:  ['', Validators.required],
            descripcionNroUno: ['', Validators.required],
            descripcionDos: ['',Validators.required],
            descripcionNroDos: ['',Validators.required],
            descripcionTres: ['',Validators.required],
            descripcionNroTres: ['',Validators.required],
            
        
          
      }); 
        
      console.log(this.updateTable.tableId);
        this.service.getTableforId(tableId).subscribe(
          datos=>{
            this.updateTable=datos;
            console.log(datos);
        },
        error=>{
          console.log("miError: "+this.errorMessage);
          this.errorMessage=<any>error;
        });
  

        this.modalService.open(content, { windowClass: 'dark-modal' });
      }

      get f() { return this.updateTableForm.controls; }
      
    guardar(){

        
        this.subUpd = true;
      if (this.updateTableForm.invalid) {
        this.respUpd=false;
        return;
      }
  
        
      
      console.log(this.updateTable);
          this.service.getActualizarTable(this.updateTable).subscribe(
            respUpd=> {
            console.log(respUpd);
            this.respUpd=respUpd;
            if(respUpd){
              this.respuesta='Se actualizo registro satisfactoriamente';
              this.listTablas();
            }else{
              this.respuesta='Hubo un problema interno por favor intente en otro momento';
              this.listTablas();
            }
          },
          error=>{
          console.log("miError: "+this.errorMessage);
          this.errorMessage=<any>error;
          });
        
        
      } 

      openDetalle(content:any, tableId:string) {
        

        
        this.service.getListTableDet(tableId).subscribe(
          datos=>{
            this.TableDetalle=datos;
            console.log(datos);
        },
        error=>{
          console.log("miError: "+this.errorMessage);
          this.errorMessage=<any>error;
        });
  
       
        this.modalService.open(content, { size: "lg", windowClass: 'dark-modal' });
      }
        
   
}