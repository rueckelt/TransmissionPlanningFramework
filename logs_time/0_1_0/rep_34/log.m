% t_n_i
% time:
generate_model = 512;
duration_to_solve_model_us = 50;
create_model = 8;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 0, 5; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0; 5, 0];
% non_allocated
non_allocated = [35];
% dl_vio
dl_vio = [0];
% st_vio
st_vio = [0];
% vioThroughput
vioThroughput = [0];
% non_allo_vio
non_allo_vio = [1960];
% nChunks
nChunks = [160];
% prefStartTime
prefStartTime = [0];
% deadline
deadline = [32];
% availBW
availBW = [28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28; 0, 0, 0, 0, 0, 24, 48, 72, 72, 72, 72, 72, 72, 72, 48, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0];
