% t_n_i
% time:
generate_model = 993;
duration_to_solve_model_us = 55;
create_model = 10;
% allocatedChunks
allocatedChunks(:,:,1) = [5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5];
allocatedChunks(:,:,2) = [0; 0; 0; 11; 24; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
allocatedChunks(:,:,3) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 12; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
allocatedChunks(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 24; 24; 24; 24; 24; 24; 24; 24; 24; 24; 24; 24];
% non_allocated
non_allocated = [30, 0, 0, 162];
% dl_vio
dl_vio = [0, 0, 0, 0];
% st_vio
st_vio = [0, 0, 0, 1440];
% vioThroughput
vioThroughput = [0, 0, 0, 0];
% non_allo_vio
non_allo_vio = [1680, 0, 0, 6804];
% nChunks
nChunks = [155, 35, 12, 450];
% prefStartTime
prefStartTime = [0, 6, 0, 18];
% deadline
deadline = [31, 7, 100000, 48];
% availBW
availBW = [29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29];
