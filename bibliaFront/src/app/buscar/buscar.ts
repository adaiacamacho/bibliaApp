import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Service } from '../service/service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatPaginatorModule, PageEvent  } from '@angular/material/paginator';

@Component({
  selector: 'app-buscar',
  imports: [CommonModule,FormsModule,MatPaginatorModule],
  templateUrl: './buscar.html',
  styleUrl: './buscar.css',
})
export class Buscar implements OnInit{
  constructor(private service:Service, private cdr:ChangeDetectorRef){}
  Sver:any="";
  versiones:any;
  qry:string="";
  limit:number=10;
  versos:any;
  offset:number=0;
  total:number=0;
  ngOnInit(): void {
    let ver=this.service.getVersion();
    if(ver){this.Sver=ver}
    this.llenarVersiones();
  }
  
 llenarVersiones(){
    this.service.getVersiones().subscribe({
      next: (res)=>{this.versiones=res.data; if(!this.Sver) this.Sver=res.data.find(v=>v.name==="Reina Valera 1909")?.id;
        this.cdr.detectChanges();this.service.setVersion(this.Sver)},
      error: (err)=> (console.log(err))
    })
  }

  buscar(event?:PageEvent){
    if(event){
      this.limit=event.pageSize;
      this.offset=event.pageIndex*event.pageSize
    }else{
      this.offset=0;
    }
    
    this.service.buscar(this.Sver,this.qry,this.limit,this.offset).subscribe({
      next:(res)=>{
        this.versos=res.data.verses;
        this.total=res.data.total;
        this.cdr.detectChanges();
      },
      error: (err)=>(console.log(err))
    }); 
  };
}
