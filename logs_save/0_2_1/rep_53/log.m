% t_n_i
% time:
generate_model = 3845;
duration_to_solve_model_us = 370;
create_model = 21;
% allocatedChunks
allocatedChunks(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 0, 0, 5; 0, 5, 0, 0; 0, 5, 0, 0; 0, 0, 0, 5; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0];
allocatedChunks(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 1; 0, 0, 0, 4; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 25; 0, 0, 0, 0; 0, 5, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
% non_allocated
non_allocated = [50, 0];
% dl_vio
dl_vio = [0, 0];
% st_vio
st_vio = [0, 0];
% vioThroughput
vioThroughput = [0, 0];
% non_allo_vio
non_allo_vio = [2800, 0];
% nChunks
nChunks = [175, 35];
% prefStartTime
prefStartTime = [0, 12];
% deadline
deadline = [35, 13];
% availBW
availBW = [32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32; 0, 0, 0, 0, 23, 46, 70, 70, 70, 70, 70, 70, 70, 46, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 42, 42, 42, 42, 42, 21, 0, 0, 0, 0, 0, 0, 0; 0, 0, 10, 20, 30, 30, 30, 30, 30, 30, 30, 20, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
