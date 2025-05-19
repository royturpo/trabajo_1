package pe.edu.upeu.sysventasjpc.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upeu.sysventasjpc.repository.CategoriaRepository
import pe.edu.upeu.sysventasjpc.repository.CategoriaRepositoryImp
import pe.edu.upeu.sysventasjpc.repository.MarcaRepository
import pe.edu.upeu.sysventasjpc.repository.MarcaRepositoryImp
import pe.edu.upeu.sysventasjpc.repository.ProductoRepository
import pe.edu.upeu.sysventasjpc.repository.ProductoRepositoryImp
import pe.edu.upeu.sysventasjpc.repository.UnidadMedidaRepository
import pe.edu.upeu.sysventasjpc.repository.UnidadMedidaRepositoryImp
import pe.edu.upeu.sysventasjpc.repository.UsuarioRepository
import pe.edu.upeu.sysventasjpc.repository.UsuarioRepositoryImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun userRepository(userRepos:UsuarioRepositoryImp):UsuarioRepository

    @Binds
    @Singleton
    abstract fun productoRepository(prodRepos:ProductoRepositoryImp): ProductoRepository
    @Binds
    @Singleton
    abstract fun marcaRepository(marcaRepos: MarcaRepositoryImp ): MarcaRepository
    @Binds
    @Singleton
    abstract fun categoriaRepository(categoriaRepos: CategoriaRepositoryImp): CategoriaRepository
    @Binds
    @Singleton
    abstract fun unidadMedRepository(unidmedRepos: UnidadMedidaRepositoryImp): UnidadMedidaRepository

}