import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, Version } from '@angular/core';
import { VersionBiblia } from '../interfaces/version';
import { Libro } from '../interfaces/libro';
import { Capitulo } from '../interfaces/capitulo';
import { CapituloCompleto } from '../interfaces/capitulo-completo';
import { Buscar } from '../interfaces/buscar';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service {
  protected base:string="http://localhost:8081/"
  constructor(private http:HttpClient){}
  private vers=new BehaviorSubject<string>("");
  versActual$=this.vers.asObservable();
  setVersion(bibleId:string){
    this.vers.next(bibleId);
  }
  getVersion(){
    return this.vers.getValue();
  }

  getVersiones(){
    return this.http.get<VersionBiblia>(this.base+"versiones");
  }
  
  getLibros(bibleId:string){
    const params=new HttpParams().set('bibleId',bibleId);
    return this.http.get<Libro>(this.base+"libros", {params});
  }
  
  getCapitulos(bibleId:string,bookId:string){
    const params=new HttpParams().set('bibleId',bibleId).set('bookId',bookId);
    return this.http.get<Capitulo>(this.base+"capitulos",{params});
  }
  
  getCapFull(bibleId:string, chapterId:string){
    const params=new HttpParams().set('bibleId',bibleId).set('chapterId',chapterId);
    return this.http.get<CapituloCompleto>(this.base+"fullcap",{params});
  }
  buscar(bibleId:string,query:string,limit:number, offset:number){
    const params=new HttpParams().set('bibleId',bibleId).set('query',query).set('limit',limit).set('offset',offset);
    return this.http.get<Buscar>(this.base+"buscar",{params});
  }
  
  
}
