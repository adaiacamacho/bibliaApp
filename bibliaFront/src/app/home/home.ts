import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Service } from '../service/service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [FormsModule,CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit{
  constructor(private service:Service, private cdr:ChangeDetectorRef){}
  versiones:any;
  Sver:any="";
  libros:any;
  Slibro:any="";
  caps:any;
  Scap:any="";
  capfull:any;
  ngOnInit(): void {
    const verConst=this.service.getVersion();
    if(verConst){this.Sver=verConst}
    this.llenarVersiones();
  }

  llenarVersiones(){
    this.service.getVersiones().subscribe({
      next: (res)=>{this.versiones=res.data; if(!this.Sver) this.Sver=res.data.find(v=>v.name==="Reina Valera 1909")?.id;
        this.cdr.detectChanges();this.service.setVersion(this.Sver);this.llenarLibros(this.Sver)},
      error: (err)=> (console.log(err))
    })
  }

  llenarLibros(version?:string){
    this.service.getLibros(version!).subscribe({
      next: (res)=>{this.libros=res.data;if(!this.Slibro)this.Slibro=res.data.find(l=>l.id==="GEN")?.id;this.cdr.detectChanges();this.llenarCapitulos(this.Sver,this.Slibro)},
      error: (err)=> (console.log(err))
    })
  }

  llenarCapitulos(version?:string, libro?:string){
this.service.getCapitulos(version!,libro!).subscribe({
      next: (res)=>{this.caps=res.data;if(!this.Scap)this.Scap=res.data.find(c=>c.number==="1")?.number;this.cdr.detectChanges();this.onChangeCap()},
      error: (err)=> (console.log(err))
    })
  }

  llenarCapFull(version?:string,capitulo?:string){
  this.service.getCapFull(version!,capitulo!).subscribe({
      next: (res)=>{this.capfull=res.data;this.capfull=res.data.content;this.cdr.detectChanges();},
      error: (err)=> (console.log(err))
    })
  }

  onChangeVer(){
    this.llenarLibros(this.Sver);
    this.service.setVersion(this.Sver);
  }
  onChangeLibro(){
    this.service.getCapitulos(this.Sver,this.Slibro).subscribe({
      next:(res)=>{
        this.caps=res.data;
        const existe= this.caps.find((c: any) => c.number === this.Scap);
        if(!existe){
          this.Scap="1";
        }
        this.onChangeCap();
      }
    })
  }
  onChangeCap(){
    let qry="";
    qry=this.Slibro+"."+this.Scap;
    this.llenarCapFull(this.Sver,qry);
  }
}
